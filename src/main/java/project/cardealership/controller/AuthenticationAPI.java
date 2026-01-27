package project.cardealership.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.cardealership.dto.reponse.AuthenticationResponse;
import project.cardealership.dto.request.SignInRequest;
import project.cardealership.dto.request.SignUpRequest;
import project.cardealership.exception.AlreadyExistException;
import project.cardealership.exception.BadCredentialException;
import project.cardealership.exception.BadRequestException;
import project.cardealership.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/api/auth/")
@RequiredArgsConstructor
public class AuthenticationAPI {

    private final UserServiceImpl userService;

    @PostMapping("/signUp")
    public AuthenticationResponse signUp(@Valid @RequestBody SignUpRequest signUpRequest) throws BadRequestException, AlreadyExistException {
       return userService.signUpResponse(signUpRequest);
    }

    @PostMapping("/signIn")
    public AuthenticationResponse signIn(@Valid @RequestBody SignInRequest signInRequest) throws BadRequestException, AlreadyExistException, BadCredentialException {
        return userService.signInResponse(signInRequest);
    }

}
