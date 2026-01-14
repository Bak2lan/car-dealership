package project.cardealership.enums;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum CarCategory {
    SEDAN("Седан"),
    SUV("Внедорожник (SUV)"),
    COUPE("Купе"),
    HATCHBACK("Хэтчбек"),
    WAGON("Универсал"),
    CONVERTIBLE("Кабриолет"),
    MINIVAN("Минивэн"),
    PICKUP("Пикап"),
    SPORTS_CAR("Спортивный автомобиль"),
    LUXURY("Люкс-класс"),
    CROSSOVER("Кроссовер"),
    LIMOUSINE("Лимузин"),
    ROADSTER("Родстер"),
    MICROCAR("Микрокар"),
    VAN("Фургон"),
    TRUCK("Грузовик"),
    ELECTRIC("Электромобиль"),
    HYBRID("Гибрид");

    private final String russianName;

    CarCategory(String russianName) {
        this.russianName = russianName;
    }


    public static CarCategory fromRussianName(String russianName){
        for (CarCategory category: CarCategory.values()){
            if (category.getRussianName().equalsIgnoreCase(russianName)){
                return category;
            }
        }
        throw new IllegalArgumentException("Неизвестная категория:"+ russianName);
    }

    @Override
    public String toString() {
        return russianName;
    }
}
