package base;

import dto.*;
import methods.LoginMethod;
import methods.ProductMethod;
import org.junit.jupiter.api.BeforeEach;
import service.RestService;

public class BaseTest {
    public RestService restService;
    public ResponseTestDTO responseTest;
    public ResponseUsersDTO responseUsers;
    public LoginMethod loginMethod;
    public ResponseLoginDTO responseLogin;
    public LoginDTO requestLogin;
    public ProductMethod productMethod;
    public ResponseProductsDTO responseProduct;
    public ProductDTO requestProduct;

    @BeforeEach
    public void setUp() {
        restService = new RestService();
        loginMethod = new LoginMethod();
        productMethod = new ProductMethod();
    }
}
