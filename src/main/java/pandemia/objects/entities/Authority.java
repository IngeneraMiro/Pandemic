package pandemia.objects.entities;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "authorities")
public class Authority extends Master implements GrantedAuthority {

    @Column(name = "authority")
    @NotNull
    private String authority;

}
