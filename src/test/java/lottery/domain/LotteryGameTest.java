package lottery.domain;

import static lottery.common.Fixture.BONUS_NUMBER;
import static lottery.common.Fixture.LOTTERY_NUMBERS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import lottery.common.FakeLotteryMachine;
import lottery.domain.dto.WinningStatisticsDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LotteryGame 은 ")
class LotteryGameTest {

    @DisplayName("구매 금액으로 살 수 있는 최대 갯수만큼의 로또를 자동구매 해야 한다.")
    @Test
    void purchaseLottery() {
        LotteryGame lotteryGame = new LotteryGame(new PurchaseAmount("3500"));

        List<Lottery> lotteries = lotteryGame.purchaseLotteries(new LotteryMachineFactory());

        assertThat(lotteries.size()).isEqualTo(3);
    }

    @DisplayName("당첨 통계와 수익률을 계산해야 한다.")
    @Test
    void calculateWinningStatistics() {
        LotteryGame lotteryGame = new LotteryGame(new PurchaseAmount("1000"));
        lotteryGame.purchaseLotteries(new FakeLotteryMachine(LOTTERY_NUMBERS));

        WinningStatisticsDto winningStatisticsDto = lotteryGame.calculateWinningStatistics(
                new WinningLottery(new Lottery(LOTTERY_NUMBERS), BONUS_NUMBER));

        assertAll(
                () -> assertThat(winningStatisticsDto.getRanks().get(Rank.FIRST)).isEqualTo(1),
                () -> assertThat(winningStatisticsDto.getWinningRate()).isEqualTo(2_000_000.0)
        );
    }
}
