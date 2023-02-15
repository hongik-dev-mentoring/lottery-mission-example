package lottery.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lottery.dto.WinningStatisticsDto;

public class LotteryGame {

    public final PurchaseAmount purchaseAmount;
    public List<Lottery> lotteries;

    public LotteryGame(final PurchaseAmount purchaseAmount) {
        this.lotteries = new ArrayList<>();
        this.purchaseAmount = purchaseAmount;
    }

    public List<Lottery> purchaseLotteries(final LotteryMachine lotteryMachine) {
        lotteries = Stream.generate(lotteryMachine::generate)
                .limit(purchaseAmount.calculateLotteries())
                .collect(Collectors.toList());
        return new ArrayList<>(lotteries);
    }

    public WinningStatisticsDto calculateWinningStatistics(final WinningLottery winningLottery) {
        final Map<Rank, Integer> ranks = calculateRanks(winningLottery);
        final int winningAmount = calculateWinningAmount(ranks);
        final double winningRate = purchaseAmount.calculateWinningRate(winningAmount);
        return WinningStatisticsDto.from(ranks, winningRate);
    }

    private int calculateWinningAmount(final Map<Rank, Integer> ranks) {
        return ranks.entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public Map<Rank, Integer> calculateRanks(final WinningLottery winningLottery) {
        return lotteries.stream()
                .map(winningLottery::calculateRank)
                .collect(Collectors.toMap(Function.identity(), Rank -> 1, Integer::sum,
                        () -> new EnumMap<>(Rank.class)));
    }
}
