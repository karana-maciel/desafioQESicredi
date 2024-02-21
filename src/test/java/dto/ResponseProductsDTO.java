package dto;

public record ResponseProductsDTO(
        int id,
        String title,
        String description,
        double price,
        double discountPercentage,
        double rating,
        int stock,
        String brand,
        String category,
        String thumbnail,
        String message
) {
}
