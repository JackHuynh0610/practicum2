package repository;
import model.*;

import java.io.IOException;

public interface IAuthenticationRepository {
    boolean save(User user) throws IOException;
    User findByUsername(String username) throws IOException;
}
