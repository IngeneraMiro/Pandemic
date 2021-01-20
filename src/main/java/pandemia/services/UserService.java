package pandemia.services;

import pandemia.objects.entities.User;

import java.util.Optional;

public interface UserService {

    void initApp();
    Optional<User> getUserById(Long id);
}
