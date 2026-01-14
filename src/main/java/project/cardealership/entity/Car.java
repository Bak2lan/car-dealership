package project.cardealership.entity;


import lombok.Getter;
import lombok.Setter;
import project.cardealership.enums.carEnum.*;


import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
public class Car {

    // ==================== ИДЕНТИФИКАЦИЯ ====================
    private Long id;                    // Уникальный идентификатор
    private String vin;                 // VIN-номер (уникальный)
    private String licensePlate;        // Госномер

    // ==================== ОСНОВНАЯ ИНФОРМАЦИЯ ====================
    private Brand brand;               // Марка (например, Toyota)
    private Model model;               // Модель (например, Camry)
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
    private List<String> imageUrls;     // Ссылки на фотографии
    private String description;         // Описание автомобиля

}


