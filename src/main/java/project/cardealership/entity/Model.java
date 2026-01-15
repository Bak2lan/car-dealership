package project.cardealership.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "models")
@Getter
@Setter
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Brand brand;
    private Integer startYear;
    private Integer endYear;
    private String generation;

    public Model() {
    }

    public Model(Long id, String name, Brand brand, Integer startYear, Integer endYear, String generation) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.startYear = startYear;
        this.endYear = endYear;
        this.generation = generation;
    }
}
