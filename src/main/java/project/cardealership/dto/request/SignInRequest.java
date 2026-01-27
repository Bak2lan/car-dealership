package project.cardealership.dto.request;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignInRequest {
    @NotBlank(message = "Username cannot be empty")
    @Size(min = 4,max = 50, message = "Length of username must be from 4 to 50 symbol")
    private String userName;
    @NotBlank(message = "Password cannot be empty")
    @Size(min = 8, max = 50,message = "Password must be more than 8 symbol")
    private String password;

}
