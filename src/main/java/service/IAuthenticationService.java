package service;
import model.*;

import java.io.IOException;

public interface IAuthenticationService {
    boolean register(User user) throws IOException;
    boolean login(String username, String password) throws IOException;
}
