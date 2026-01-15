package project.cardealership.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import project.cardealership.enums.dealEnum.DealStatus;
import java.time.LocalDate;

@Entity
@Table(name = "deals")
@Getter
@Setter
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dealNumber;
    private LocalDate dealDate;
    private LocalDate createdAt;
    private DealStatus dealStatus;
    @ManyToOne
    private Car car;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id)")
    private User buyer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private User manager;

    public Deal() {
    }

    public Deal(Long id, String dealNumber, LocalDate dealDate, LocalDate createdAt, DealStatus dealStatus, Car car, User buyer, User manager) {
        this.id = id;
        this.dealNumber = dealNumber;
        this.dealDate = dealDate;
        this.createdAt = createdAt;
        this.dealStatus = dealStatus;
        this.car = car;
        this.buyer = buyer;
        this.manager = manager;
    }
}
