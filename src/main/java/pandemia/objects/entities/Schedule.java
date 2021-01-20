package pandemia.objects.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "schedule")
public class Schedule extends Master{



}
