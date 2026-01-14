package project.cardealership.entity;

import lombok.Getter;
import lombok.Setter;
import project.cardealership.enums.dealEnum.DealStatus;

import java.time.LocalDate;
@Getter
@Setter
public class Deal {

    private Long id;
    private String dealNumber;
    private LocalDate dealDate;
    private LocalDate createdAt;
    private DealStatus dealStatus;
    private Long carId;




}
