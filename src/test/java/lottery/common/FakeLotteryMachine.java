package lottery.common;

import java.util.List;
import lottery.domain.Lottery;
import lottery.domain.LotteryMachine;

public class FakeLotteryMachine implements LotteryMachine {

    private final Lottery lottery;

    public FakeLotteryMachine(final List<Integer> lotteryNumbers) {
        this.lottery = new Lottery(lotteryNumbers);
    }

    @Override
    public Lottery generate() {
        return lottery;
    }
}
