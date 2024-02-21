package methods;

import com.github.javafaker.Faker;
import dto.ProductDTO;

public class ProductMethod {
    private static Faker faker = new Faker();

    public ProductDTO createProduct() {
        return new ProductDTO(
                faker.commerce().productName(),
                faker.lorem().sentence(),
                faker.number().numberBetween(1, 1000),
                faker.number().randomDouble(2, 1, 100),
                faker.number().numberBetween(1, 5),
                faker.number().numberBetween(1, 10),
                faker.company().name(),
                faker.commerce().department(),
                "https://i.dummyjson.com/data/products/11/thumnail.jpg"
                );
    }
}
