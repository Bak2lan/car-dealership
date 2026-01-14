package project.cardealership.enums.dealEnum;

public enum DealStatus {
    NEW("НОВАЯ"),
    RESERVED("ЗАБРОНИРОВАНА"),
    PAID("ОПЛАЧЕНА"),
    DELIVERED("ПЕРЕДАНА"),
    CANCELLED("ОТМЕНЕНА");

    DealStatus (String russianName){
    }
}
