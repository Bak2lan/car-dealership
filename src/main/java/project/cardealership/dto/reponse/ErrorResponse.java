package project.cardealership.dto.reponse;

import java.util.List;

public record ErrorResponse(
        String status,
        List<String> details
) {
}
