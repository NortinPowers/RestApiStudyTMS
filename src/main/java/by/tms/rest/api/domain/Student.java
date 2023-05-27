package by.tms.rest.api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "students")
@NoArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
public class Student extends BaseEntity {

    private String name;
    private String surname;
    private Integer age;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    private String course;
}
