package lottery.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LotteryGame {

    public final PurchaseAmount purchaseAmount;
    public List<Lottery> lotteries;

    public LotteryGame(final PurchaseAmount purchaseAmount) {
        this.lotteries = new ArrayList<>();
        this.purchaseAmount = purchaseAmount;
    }

    public List<Lottery> purchaseLotteries() {
        lotteries = Stream.generate(Lottery::generate)
                .limit(purchaseAmount.calculateLotteries())
                .collect(Collectors.toList());
        return new ArrayList<>(lotteries);
    }
}
