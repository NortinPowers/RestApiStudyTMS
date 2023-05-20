package by.tms.rest.api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "cities")
public class City extends BaseEntity {

    private String name;
    private String info;
    @OneToMany(mappedBy = "city")
    private List<Student> students;
}
