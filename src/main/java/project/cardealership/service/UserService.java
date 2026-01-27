package project.cardealership.service;

import project.cardealership.dto.reponse.AuthenticationResponse;
import project.cardealership.dto.reponse.SimpleResponse;
import project.cardealership.dto.reponse.UsersGetAll;
import project.cardealership.dto.request.SignInRequest;
import project.cardealership.dto.request.SignUpRequest;
import project.cardealership.dto.request.UserRequest;
import project.cardealership.exception.AlreadyExistException;
import project.cardealership.exception.BadCredentialException;
import project.cardealership.exception.BadRequestException;
import project.cardealership.exception.handler.AccessDeniedException;

import java.util.List;

public interface UserService {
    AuthenticationResponse signUpResponse(SignUpRequest signUpRequest) throws AlreadyExistException, BadRequestException;
    AuthenticationResponse signInResponse(SignInRequest signInRequest) throws BadCredentialException;

    SimpleResponse saveUserWithRole(UserRequest userRequest) throws AccessDeniedException, BadRequestException, AlreadyExistException;
    SimpleResponse updateUser(Long id);
    SimpleResponse deleteUser(Long id);
    List<UsersGetAll> getAllUsers();

}
