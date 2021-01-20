package pandemia.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BeanRegister {

    @Bean
    ModelMapper mapper(){
        return new ModelMapper();
    }

    @Bean
    PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}
