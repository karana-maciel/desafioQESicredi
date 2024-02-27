package dto;

import java.util.List;

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
        List<String> images,
        String message,
        List<Products> products,
        int total,
        int skip,
        int limit
) {
    public record Products (
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
            List<String> images
    ) {
    }
}

