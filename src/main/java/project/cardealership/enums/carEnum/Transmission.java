package project.cardealership.enums.carEnum;

public enum Transmission {
    AUTOMATIC("Автоматическая"),
    MANUAL("Механическая"),
    ROBOT("Роботизированная"),
    VARIATOR("Вариатор"),
    SEMI_AUTOMATIC("Полуавтоматическая"),
    DUAL_CLUTCH("Двойное сцепление"),
    TIPTRONIC("Типтроник"),
    DIRECT_SHIFT("Прямое переключение");

    private final String russianName;

    Transmission(String russianName) {
        this.russianName = russianName;
    }

    public String getRussianName() {
        return russianName;
    }


    public static Transmission fromRussianName(String russianName) {
        for (Transmission transmission : Transmission.values()) {
            if (transmission.getRussianName().equalsIgnoreCase(russianName)) {
                return transmission;
            }
        }
        throw new IllegalArgumentException("Неизвестный тип трансмиссии: " + russianName);
    }


    public boolean isAutomatic() {
        return this == AUTOMATIC ||
               this == VARIATOR ||
               this == SEMI_AUTOMATIC ||
               this == ROBOT ||
               this == DUAL_CLUTCH ||
               this == TIPTRONIC ||
               this == DIRECT_SHIFT;
    }


    public String getDescription() {
        switch (this) {
            case AUTOMATIC:
                return "Гидромеханическая автоматическая коробка передач";
            case MANUAL:
                return "Механическая коробка передач с ручным переключением";
            case ROBOT:
                return "Роботизированная механика с автоматическим сцеплением";
            case VARIATOR:
                return "Бесступенчатая трансмиссия с плавным изменением передаточного числа";
            case SEMI_AUTOMATIC:
                return "Механическая коробка с автоматизированным управлением";
            case DUAL_CLUTCH:
                return "Роботизированная коробка с двумя сцеплениями для быстрого переключения";
            case TIPTRONIC:
                return "Автоматическая коробка с возможностью ручного переключения";
            case DIRECT_SHIFT:
                return "Роботизированная коробка с прямым переключением";
            default:
                return getRussianName();
        }
    }


    public String getAbbreviation() {
        switch (this) {
            case AUTOMATIC: return "АТ";
            case MANUAL: return "МТ";
            case ROBOT: return "РКПП";
            case VARIATOR: return "CVT";
            case SEMI_AUTOMATIC: return "АМТ";
            case DUAL_CLUTCH: return "DSG";
            case TIPTRONIC: return "Tiptronic";
            case DIRECT_SHIFT: return "DSG";
            default: return name();
        }
    }

    @Override
    public String toString() {
        return russianName;
    }
}