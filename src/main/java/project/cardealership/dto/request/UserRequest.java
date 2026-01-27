package project.cardealership.dto.request;
import jakarta.validation.constraints.*;

import lombok.*;
import project.cardealership.enums.userEnum.Role;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequest {
    @NotBlank(message = "Can not be empty")
    @Size(min = 3,max = 50,message = "First name must be from 3, to 50 symbols")
    private String firstName;
    @NotBlank(message = "Can not be empty")
    @Size(min = 3,max = 50,message = "Last name must be from 3, to 50 symbols")
    private String lastName;
    @NotBlank(message = "Phone number cannot be empty")
    @Pattern(regexp = "^\\+996\\d{9}$", message = "Phone number must be start with +996 and consist 9 symbol")
    private String phoneNumber;
    @NotBlank(message = "Username cannot be empty")
    @Size(min = 4,max = 50, message = "Length of username must be from 4, to 50 symbols")
    private String userName;
    @Email(message = "Incorrect format")
    @NotBlank(message = "Email cannot be empty")
    private String email;
    @NotBlank(message = "Password cannot be ")
    @Size(min = 8, max = 50, message= "Password length must be from 8, to 50 symbols")
    private String password;
    @NotBlank(message = "Fill the role field")
    private Role role;
}
