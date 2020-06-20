import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

import static java.lang.String.format;

public class MultithreadClient {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(8);
        Counter counter = new Counter();

        long start = System.nanoTime();

        List<Future<Double>> futures = new ArrayList<>();
        for (int i = 0; i < 400; i++) {
            final int j = i;
            futures.add(CompletableFuture.supplyAsync(new Supplier<Double>() {
                @Override
                public Double get() {
                    return counter.count(j);
                }
            }, threadPool));
        }

        double value = 0;
        for (Future<Double> future : futures) {
            value += future.get();
        }

        System.out.println(format("Executed by %d s, value : %f",
                (System.nanoTime() - start) / (1000_000_000),
                value));

        threadPool.shutdown();
    }
}