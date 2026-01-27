package project.cardealership.dto.reponse;

import lombok.*;
import project.cardealership.enums.userEnum.Role;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersGetAll {
    private Long id;
    private String fullName;
    private Role role;
    private String email;

}
