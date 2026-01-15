package project.cardealership.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import project.cardealership.enums.userEnum.Role;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private Role role = Role.ROLE_USER;
    private LocalDate createdAt;
    @OneToMany(mappedBy = "buyer", fetch = FetchType.LAZY)
    private List<Deal> boughtDeals = new ArrayList<>();
    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    private List<Deal> managedDeals = new ArrayList<>();
    @OneToMany(mappedBy = "addedBy", fetch = FetchType.LAZY)
    private List<Car> addedCars = new ArrayList<>();
    @OneToMany(mappedBy = "responsibleManager",fetch = FetchType.LAZY)
    private List<Car> responsibleCars = new ArrayList<>();

    public User() {
    }

    public User(Long id, String username, String firstName, String lastName, String email, String password, String phoneNumber, Role role, LocalDate createdAt, List<Deal> boughtDeals, List<Deal> managedDeals, List<Car> addedCars, List<Car> responsibleCars) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.createdAt = createdAt;
        this.boughtDeals = boughtDeals;
        this.managedDeals = managedDeals;
        this.addedCars = addedCars;
        this.responsibleCars = responsibleCars;
    }
}
