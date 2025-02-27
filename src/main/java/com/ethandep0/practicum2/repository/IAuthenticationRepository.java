package com.ethandep0.practicum2.repository;
import java.io.IOException;

import com.ethandep0.practicum2.model.*;

public interface IAuthenticationRepository {
    boolean save(User user) throws IOException;
    User findByUsername(String username) throws IOException;
}
