package com.ethandep0.practicum2.service;
import java.io.IOException;

import com.ethandep0.practicum2.model.*;

public interface IAuthenticationService {
    boolean register(User user) throws IOException;
    boolean login(String username, String password) throws IOException;
}
