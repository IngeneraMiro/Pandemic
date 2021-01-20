package pandemia.objects.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
abstract class Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,updatable = false)
    private long id;
}
