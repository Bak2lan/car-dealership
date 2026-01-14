package project.cardealership.enums;

import lombok.Getter;

@Getter
public enum CarStatus {
    IN_STOCK("На складе"),
    ON_DISPLAY("На витрине"),
    RESERVED("Забронирован"),
    SOLD("Продан"),
    IN_SERVICE("На обслуживании"),
    DELIVERED("Доставлен"),
    UNAVAILABLE("Недоступен"),
    TEST_DRIVE("Тест-драйв"),
    PROCESSING("В обработке"),
    READY_FOR_DELIVERY("Готов к выдаче"),
    RESERVED_PENDING("Бронь (ожидание оплаты)");

    private final String russianName;

    CarStatus(String russianName) {
        this.russianName = russianName;
    }


    public boolean isAvailableForSale() {
        return this == IN_STOCK || this == ON_DISPLAY || this == TEST_DRIVE;
    }


    public boolean isSold() {
        return this == SOLD || this == DELIVERED;
    }


    public boolean canBeReserved() {
        return this == IN_STOCK || this == ON_DISPLAY;
    }


    public static CarStatus fromRussianName(String russianName) {
        for (CarStatus status : CarStatus.values()) {
            if (status.getRussianName().equalsIgnoreCase(russianName)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Неизвестный статус: " + russianName);
    }

    @Override
    public String toString() {
        return russianName;
    }
}