package pandemia.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandemia.repositories.AuthorityRepository;
import pandemia.services.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    private final AuthorityRepository repository;

    @Autowired
    public AuthorityServiceImpl(AuthorityRepository repository) {
        this.repository = repository;
    }
}
