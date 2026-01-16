package project.cardealership.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import project.cardealership.enums.userEnum.Role;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
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

    @Override
    @Nonnull
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public @Nullable String getPassword() {
        return password;
    }

    @Override
    @Nonnull
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
