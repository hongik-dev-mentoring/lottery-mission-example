package lottery.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lottery.domain.Lottery;
import lottery.domain.Rank;
import lottery.dto.WinningStatisticsDto;

public class OutputView {

    public static void printPurchasedLotteries(final List<Lottery> lotteries) {
        System.out.println(lotteries.size() + "개를 구매했습니다.");
        lotteries.forEach(System.out::println);
        System.out.print("\n");
    }

    public static void printWinningStatistics(final WinningStatisticsDto winningStatisticsDto) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        final Map<Rank, Integer> ranks = winningStatisticsDto.getRanks();
        Arrays.stream(Rank.values())
                .forEach(rank -> printMatchedStatistics(rank, ranks));
        System.out.printf("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n",
                winningStatisticsDto.getWinningRate());
    }

    private static void printMatchedStatistics(final Rank expectedRank, final Map<Rank, Integer> ranks) {
        int matched = 0;
        if (ranks.containsKey(expectedRank)) {
            matched = ranks.get(expectedRank);
        }
        System.out.println(expectedRank.getMatchedNumbers() + "개 일치 ("
                + expectedRank.getPrize() + "원)- " + matched + "개");
    }
}
