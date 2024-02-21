package methods;

import dto.LoginDTO;
import util.StaticValue;

public class LoginMethod {
    public LoginDTO Login() {
        return new LoginDTO(
                StaticValue.username,
                StaticValue.password
        );
    }
}