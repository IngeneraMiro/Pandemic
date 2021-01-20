package pandemia.objects.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "practices")
public class Practice extends Master{

    @Column(name = "practice_name")
    @NotNull
    private String name;
    @NotNull
    @Column(name = "number")
    private String number;
    @OneToMany(mappedBy = "practice")
    private Set<User> members = new HashSet<>();
    @OneToMany(mappedBy = "practice")
    private Set<Office> offices;

}
