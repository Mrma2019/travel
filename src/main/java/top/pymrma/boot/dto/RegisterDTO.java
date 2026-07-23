package top.pymrma.boot.dto;

public record RegisterDTO(
        String username,
        String email,
        String password
) {
}
