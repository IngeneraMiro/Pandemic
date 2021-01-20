package pandemia.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pandemia.objects.entities.Authority;
import pandemia.objects.entities.PossibleAuthorities;
import pandemia.objects.entities.User;
import pandemia.repositories.AuthorityRepository;
import pandemia.repositories.UserRepository;
import pandemia.services.UserService;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final ModelMapper mapper;
    private final UserRepository repository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(ModelMapper mapper, UserRepository repository, AuthorityRepository authorityRepository, PasswordEncoder encoder) {
        this.mapper = mapper;
        this.repository = repository;
        this.authorityRepository = authorityRepository;
        this.encoder = encoder;
    }


    @Override
    public void initApp() {
        for(PossibleAuthorities a: PossibleAuthorities.values()){
            Authority authority = new Authority();
            authority.setAuthority(String.format("ROLE_%s",a.toString()));
            authorityRepository.save(authority);
        }
        if(repository.count()==0){
            User user = new User();
            user.setUsername("A75820483");
            user.setFName("Мирослав");
            user.setSName("Стефанов");
            user.setLName("Щрегарски");
            user.setRegisteredOn(LocalDateTime.now());
            user.setPassword(encoder.encode("Password1"));
            user.setEnabled(true);
            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setCredentialsNonExpired(true);
            user.addAuthority(authorityRepository.findAuthorityByAuthority("ROLE_ADMIN"));
            repository.save(user);



        }
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return repository.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return repository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Потребител симе"+username+"не беше намерен!"));
    }
}
