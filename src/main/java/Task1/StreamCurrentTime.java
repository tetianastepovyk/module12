package Task1;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StreamCurrentTime {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
       // long startTime5ms = System.currentTimeMillis();
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.scheduleAtFixedRate(
                () -> {
                    long currentTime = System.currentTimeMillis();
                    System.out.println(TimeUnit.MILLISECONDS.toSeconds(currentTime - startTime) + " seconds have passed");
                },
                1,
                1,
                TimeUnit.SECONDS
        );
        executorService.scheduleAtFixedRate(
                () -> System.out.println("5 seconds have passed!!!"),
                5,
                5,
                TimeUnit.SECONDS
        );
    }
}
