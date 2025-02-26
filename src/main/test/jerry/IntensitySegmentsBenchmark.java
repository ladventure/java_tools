package jerry;

import jerry.IntensitySegments;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * performance test
 *
 * @date 2023/11/22 11:14
 **/

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class IntensitySegmentsBenchmark {
    private IntensitySegments segments;
    private Random random;

    @Setup(Level.Invocation)
    public void setup() {
        segments = new IntensitySegments();

        // create Random test instance
        random = new Random();

    }

    @Benchmark
    public void benchmark_add() {
        int from=random.nextInt(1000)/10;
        int to=from+random.nextInt(1000)/10;
        int amount=random.nextInt(10);
        segments.add(from, to, amount);
    }

    @Benchmark
    public void benchmark_set() {
        int from=random.nextInt(1000)/10;
        int to=from+random.nextInt(1000)/10;
        int amount=random.nextInt(10);
        segments.set(from, to, amount);
    }

    @Benchmark
    public void benchmark_toString() {
        for (int i = 0; i < random.nextInt(1000); i++) {
            int from=random.nextInt(1000)/10;
            int to=from+random.nextInt(1000)/10;
            int amount=random.nextInt(10);
            segments.set(from, to, amount);
        }
        segments.toString();
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(IntensitySegments.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }
}