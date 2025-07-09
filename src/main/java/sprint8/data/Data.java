package sprint8.data;

import java.time.Instant;

public class Data {
    public static void main(String[] args) {
        long millis = 9_000_000_000L; // количество миллисекунд

        System.out.println(Instant.ofEpochMilli(millis)); // дата millis миллисекунд после Unix-эпохи
        System.out.println(Instant.ofEpochMilli(-millis)); // дата millis миллисекунд до Unix-эпохи
    }
}
