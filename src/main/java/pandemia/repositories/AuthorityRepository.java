package pandemia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pandemia.objects.entities.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Long> {

    Authority findAuthorityByAuthority(String auth);

}
