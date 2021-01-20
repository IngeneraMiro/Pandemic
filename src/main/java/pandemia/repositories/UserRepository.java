package pandemia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pandemia.objects.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
   Optional<User> findUserByUsername(String username);

}
