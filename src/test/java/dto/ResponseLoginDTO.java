package dto;

public record ResponseLoginDTO(
        int id,
        String username,
        String email,
        String firstName,
        String lastName,
        String gender,
        String image,
        String token,
        String message
) {
}
