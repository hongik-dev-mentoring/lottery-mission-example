package lottery.domain;

import static lottery.domain.Lottery.LOTTERY_SIZE;
import static lottery.domain.Lottery.MAX_NUMBER;
import static lottery.domain.Lottery.MIN_NUMBER;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryMachineFactory implements LotteryMachine {

    private static final List<Integer> LOTTERY_NUMBER;

    static {
        LOTTERY_NUMBER = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public Lottery generate() {
        Collections.shuffle(LOTTERY_NUMBER);
        List<Integer> lotteryNumbers = LOTTERY_NUMBER.stream()
                .limit(LOTTERY_SIZE)
                .collect(Collectors.toList());
        return new Lottery(lotteryNumbers);
    }
}
