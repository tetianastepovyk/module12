package Task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StreamFizzBuzzString {

    private final int n = 20;
    public static volatile AtomicInteger number = new AtomicInteger(1);

    public BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(5);
        FizzBuzzService fizzBuzzService = new FizzBuzzService();
        fizzBuzzService.setN(20);
        service.submit(fizzBuzzService::fizz);
        service.submit(fizzBuzzService::buzz);
        service.submit(fizzBuzzService::fizzbuzz);
        service.submit(fizzBuzzService::number);
        service.submit(fizzBuzzService::print);
        service.shutdown();
    }
}
