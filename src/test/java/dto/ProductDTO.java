package dto;

public record ProductDTO(
        String title,
        String description,
        double price,
        double discountPercentage,
        double rating,
        int stock,
        String brand,
        String category,
        String thumbnail
) {
}
