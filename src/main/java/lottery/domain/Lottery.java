package lottery.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottery {

    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final int LOTTERY_SIZE = 6;
    private static final String LOTTERY_SIZE_ERROR = "로또 사이즈는 6이어야 합니다.";
    private static final String LOTTERY_NUMBER_DUPLICATED_ERROR = "로또 숫자는 중복일 수 없습니다.";
    private static final String LOTTERY_NUMBER_INVALID_RANGE_ERROR = "로또 숫자는 1-45 사이 숫자여야 합니다.";
    private static final List<Integer> LOTTERY_NUMBER;

    private final List<Integer> numbers;

    static {
        LOTTERY_NUMBER = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    public static Lottery generate() {
        Collections.shuffle(LOTTERY_NUMBER);
        List<Integer> lotteryNumbers = LOTTERY_NUMBER.stream()
                .limit(LOTTERY_SIZE)
                .collect(Collectors.toList());
        return new Lottery(lotteryNumbers);
    }

    public Lottery(List<Integer> lotteryNumbers) {
        validateLotteryNumber(lotteryNumbers);
        this.numbers = lotteryNumbers;
    }

    private void validateLotteryNumber(final List<Integer> lotteryNumbers) {
        validateSize(lotteryNumbers);
        validateDuplicatedNumber(lotteryNumbers);
        validateLotteryNumberRange(lotteryNumbers);
    }

    private void validateSize(final List<Integer> lotteryNumbers) {
        if (lotteryNumbers.size() != LOTTERY_SIZE) {
            throw new IllegalArgumentException(LOTTERY_SIZE_ERROR);
        }
    }

    private void validateDuplicatedNumber(final List<Integer> lotteryNumbers) {
        List<Integer> uniqueNumbers = lotteryNumbers.stream()
                .distinct()
                .collect(Collectors.toList());

        if (uniqueNumbers.size() != lotteryNumbers.size()) {
            throw new IllegalArgumentException(LOTTERY_NUMBER_DUPLICATED_ERROR);
        }
    }

    private void validateLotteryNumberRange(final List<Integer> lotteryNumbers) {
        if (!isNumberOfInvalidRange(lotteryNumbers)) {
            throw new IllegalArgumentException(LOTTERY_NUMBER_INVALID_RANGE_ERROR);
        }
    }

    private boolean isNumberOfInvalidRange(final List<Integer> lotteryNumbers) {
        return !lotteryNumbers.stream()
                .anyMatch(number -> MAX_NUMBER < number || number < MIN_NUMBER);
    }

    public int findTheNumberOfSameNumbers(final Lottery lottery) {
        final ArrayList<Integer> sameNumbers = new ArrayList<>(numbers);
        sameNumbers.retainAll(lottery.numbers);
        return sameNumbers.size();
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
