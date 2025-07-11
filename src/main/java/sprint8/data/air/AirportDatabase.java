package sprint8.data.air;

class AirportDatabase {
    private static Airport vnukovo = new Airport(
            "Внуково",
            "Москва",
            "MOSCOW          ",
            "Europe/Moscow"
    );

    private static Airport pulkovo = new Airport(
            "Пулково",
            "Санкт-Петербург",
            "SAINT-PETERSBURG",
            "Europe/Moscow"
    );

    private static Airport vladivostok = new Airport(
            "Владивосток",
            "Владивосток",
            "VLADIVOSTOK     ",
            "Asia/Vladivostok"
    );

    private static Airport koltsovo = new Airport(
            "Кольцово",
            "Екатеринбург",
            "YEKATERINBURG   ",
            "Asia/Yekaterinburg"
    );

    public static Airport getAirportByCode(String airportCode) {
        switch (airportCode) {
            case "VKO":
                return vnukovo;
            case "LED":
                return pulkovo;
            case "VVO":
                return vladivostok;
            case "SVX":
                return koltsovo;
            default:
                throw new IllegalStateException("Неизвестный код аэропорта: " + airportCode);
        }
    }
}
