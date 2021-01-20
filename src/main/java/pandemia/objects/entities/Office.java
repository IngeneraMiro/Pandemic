package pandemia.objects.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "offices")
public class Office extends Master{

    @Column(name = "address")
    @NotNull
    private String address;
    @ManyToOne
    private Schedule schedule;
    @ManyToOne
    private Practice practice;


}
