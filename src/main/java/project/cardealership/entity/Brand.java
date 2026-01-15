package project.cardealership.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "brands")
@Getter
@Setter
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(name = "country_of_origin")
    private String countryOfOrigin;
    @OneToMany(mappedBy = "brand",cascade = CascadeType.ALL)
    private List<Model> models;

    public Brand() {
    }

    public Brand(Long id, String name, String countryOfOrigin, List<Model> models) {
        this.id = id;
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
        this.models = models;
    }
}
