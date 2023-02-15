package lottery.domain.dto;

import java.util.Map;
import lottery.domain.Rank;

public class WinningStatisticsDto {

    private final Map<Rank, Integer> ranks;
    private final double winningRate;

    private WinningStatisticsDto(final Map<Rank, Integer> ranks, final double winningRate) {
        this.ranks = ranks;
        this.winningRate = winningRate;
    }

    public static WinningStatisticsDto from(final Map<Rank, Integer> ranks, final double winningRate) {
        return new WinningStatisticsDto(ranks, winningRate);
    }

    public Map<Rank, Integer> getRanks() {
        return ranks;
    }

    public double getWinningRate() {
        return winningRate;
    }

    @Override
    public String toString() {
        return "WinningStatisticsDto{" +
                "ranks=" + ranks +
                ", winningRate=" + winningRate +
                '}';
    }
}
