package pandemia.objects.entities;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User extends Master implements UserDetails {

    @Column(name = "username")
    @NotNull
    private String username;
    @Column(name = "password",columnDefinition = "TEXT")
    @NotNull
    private String password;
    @Column(name = "first_name")
    @NotNull
    private String fName;
    @Column(name = "sure_name")
    @NotNull
    private String sName;
    @Column(name = "last_name")
    @NotNull
    private String lName;
    @Column(name = "registered_on")
    @NotNull
    private LocalDateTime registeredOn;
    @Column(name = "is_enabled")
    @NotNull
    private boolean isEnabled;
    @Column(name = "is_not_expired")
    private boolean isAccountNonExpired;
    @Column(name = "is_not_locked")
    private boolean isAccountNonLocked;
    @Column(name = "credential_not_expired")
    private boolean isCredentialsNonExpired;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private Set<Authority> authorities = new HashSet<>();

    @Override
    public Set<Authority> getAuthorities() {
        return this.authorities;
    }

    public void addAuthority(Authority authority){
        this.authorities.add(authority);
    }

}
