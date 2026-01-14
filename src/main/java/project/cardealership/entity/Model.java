package project.cardealership.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Model {
    private Long id;
    private String name;
    private Brand brand;
    private Integer startYear;
    private Integer endYear;
    private String generation;


}
