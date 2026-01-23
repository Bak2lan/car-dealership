package project.cardealership.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class SignUpRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String userName;
    private String email;
    private String password;

}
