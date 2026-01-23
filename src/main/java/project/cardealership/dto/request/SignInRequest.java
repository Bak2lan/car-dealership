package project.cardealership.dto.request;

import jakarta.annotation.Nonnull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignInRequest {
    private String userName;
    private String password;

}
