package lottery.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottery {

    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final int LOTTERY_SIZE = 6;
    private static final List<Integer> LOTTERY_NUMBER;

    private final List<Integer> numbers;

    static {
        LOTTERY_NUMBER = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    private Lottery(List<Integer> lotteryNumber) {
        this.numbers = lotteryNumber;
    }

    public static Lottery generate() {
        Collections.shuffle(LOTTERY_NUMBER);
        List<Integer> lotteryNumbers = LOTTERY_NUMBER.stream()
                .limit(LOTTERY_SIZE)
                .collect(Collectors.toList());
        return new Lottery(lotteryNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Lottery)) {
            return false;
        }
        final Lottery lottery = (Lottery) o;
        return Objects.equals(numbers, lottery.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "Lottery{" +
                "numbers=" + numbers +
                '}';
    }
}
