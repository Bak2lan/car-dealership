package project.cardealership.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import project.cardealership.enums.carEnum.*;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "cars")
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // ==================== ИДЕНТИФИКАЦИЯ ====================
    private Long id;                    // Уникальный идентификатор
    @Column(unique = true)
    private String vin;                 // VIN-номер (уникальный)
    @Column(unique = true)
    private String licensePlate;        // Госномер

    // ==================== ОСНОВНАЯ ИНФОРМАЦИЯ ====================
    @ManyToOne
    private Brand brand;                // Марка (например, Toyota)
    @ManyToOne
    private Model model;                // Модель (например, Camry)
    private int year;                   // Год выпуска
    private CarCategory category;       // Категория (седан, внедорожник и т.д.)
    private TrimLevel trimLevel;        // Комплектация (базовая, люкс и т.д.)
    private boolean isNew;

    // ==================== ЦЕНА И СТАТУС ====================
    private BigDecimal price;           // Цена
    private BigDecimal originalPrice;
    private BigDecimal discountAmount;
    private CarStatus carStatus;        // Статус автомобиля (на складе, продан и т.д.)


    // ==================== ТЕХНИЧЕСКИЕ ХАРАКТЕРИСТИКИ ====================
    private EngineType engineType;      // Тип двигателя (бензин, дизель и т.д.)
    private Double engineVolume;        // Объем двигателя (литры)
    private Integer horsePower;         // Мощность (л.с.)
    private Transmission transmission;  // Коробка передач
    private DriveType driveType;        // Привод (передний, задний, полный)
    private Double fuelConsumption;     // Расход топлива (л/100км)
    private Integer mileage;            // Пробег (км)

    // ==================== ВНЕШНИЙ ВИД И ИНТЕРЬЕР ====================
    private String colorExterior;       // Цвет кузова
    private String colorInterior;       // Цвет салона
    private String interiorMaterial;    // Материал салона (кожа, ткань и т.д.)

    // ==================== ДОПОЛНИТЕЛЬНАЯ ИНФОРМАЦИЯ ====================

    private int doorsCount;             // Количество дверей
    private int seatsCount;             // Количество мест
    @ElementCollection
    private List<String> imageUrls;     // Ссылки на фотографии
    private String description;         // Описание автомобиля

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Deal> deals = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "added_by_id")
    private User addedBy;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responsible_manager_id")
    private User responsibleManager;

    public Car() {
    }

    public Car(Long id, String vin, String licensePlate, Brand brand, Model model, int year, CarCategory category, TrimLevel trimLevel, boolean isNew, BigDecimal price, BigDecimal originalPrice, BigDecimal discountAmount, CarStatus carStatus, EngineType engineType, Double engineVolume, Integer horsePower, Transmission transmission, DriveType driveType, Double fuelConsumption, Integer mileage, String colorExterior, String colorInterior, String interiorMaterial, int doorsCount, int seatsCount, List<String> imageUrls, String description, List<Deal> deals, User addedBy, User responsibleManager) {
        this.id = id;
        this.vin = vin;
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.category = category;
        this.trimLevel = trimLevel;
        this.isNew = isNew;
        this.price = price;
        this.originalPrice = originalPrice;
        this.discountAmount = discountAmount;
        this.carStatus = carStatus;
        this.engineType = engineType;
        this.engineVolume = engineVolume;
        this.horsePower = horsePower;
        this.transmission = transmission;
        this.driveType = driveType;
        this.fuelConsumption = fuelConsumption;
        this.mileage = mileage;
        this.colorExterior = colorExterior;
        this.colorInterior = colorInterior;
        this.interiorMaterial = interiorMaterial;
        this.doorsCount = doorsCount;
        this.seatsCount = seatsCount;
        this.imageUrls = imageUrls;
        this.description = description;
        this.deals = deals;
        this.addedBy = addedBy;
        this.responsibleManager = responsibleManager;
    }
}


