package project.cardealership.service;

import project.cardealership.dto.reponse.AuthenticationResponse;
import project.cardealership.dto.request.SignInRequest;
import project.cardealership.dto.request.SignUpRequest;
import project.cardealership.exception.AlreadyExistException;
import project.cardealership.exception.BadCredentialException;
import project.cardealership.exception.BadRequestException;

public interface UserService {
    AuthenticationResponse signUpResponse(SignUpRequest signUpRequest) throws AlreadyExistException, BadRequestException;
    AuthenticationResponse signInResponse(SignInRequest signInRequest) throws BadCredentialException;
}
