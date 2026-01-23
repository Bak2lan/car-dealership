package project.cardealership.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.cardealership.config.jwtConfig.JwtService;
import project.cardealership.dto.reponse.AuthenticationResponse;
import project.cardealership.dto.request.SignInRequest;
import project.cardealership.dto.request.SignUpRequest;
import project.cardealership.entity.User;
import project.cardealership.exception.AlreadyExistException;
import project.cardealership.exception.BadCredentialException;
import project.cardealership.exception.BadRequestException;
import project.cardealership.repository.UserRepository;
import project.cardealership.service.UserService;

import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final JwtService jwtService;

    private final   PasswordEncoder passwordEncoder;

    @Override
    public AuthenticationResponse signUpResponse(SignUpRequest signUpRequest) throws AlreadyExistException,
            BadRequestException {
        if (userRepository.findByEmail(signUpRequest.getEmail()).isPresent()){
            throw new AlreadyExistException("User with this email is already exist");
        }
        if (userRepository.existsByUsername(signUpRequest.getUserName())){
            throw new AlreadyExistException("User with this user name is already exist");
        }
        User user = new User();
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setPhoneNumber(signUpRequest.getPhoneNumber());
        user.setUsername(signUpRequest.getUserName());
        user.setEmail(signUpRequest.getEmail());
        if (signUpRequest.getPassword().length()<8){
            throw new BadRequestException("User password's length must be more than 8 symbol ");
        }
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setCreatedAt(LocalDate.now());
        userRepository.save(user);
        String token = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .id(user.getId())
                .role(user.getRole().name())
                .token(token)
                .email(user.getEmail())
                .build();
    }

    @Override
    public AuthenticationResponse signInResponse(SignInRequest signInRequest) throws BadCredentialException {
        if (!userRepository.existsByUsername(signInRequest.getUserName())){
            throw new BadCredentialException("User name is incorrect");
        }
        User user = userRepository.findByUsername(signInRequest.getUserName()).orElseThrow(() -> new BadCredentialException("User name is incorrect"));
        if (!passwordEncoder.matches(signInRequest.getPassword(), user.getPassword())){
            throw new BadCredentialException("Password incorrect");
        }
        String token = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .id(user.getId())
                .token(token)
                .email(user.getEmail())
                .role(user.getRole().name())
                .build();
    }
}
