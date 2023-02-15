package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LotteryGame 은 ")
class LotteryGameTest {

    @DisplayName("구매 금액으로 살 수 있는 최대 갯수만큼의 로또를 자동구매 해야 한다.")
    @Test
    void purchaseLottery() {
        LotteryGame lotteryGame = new LotteryGame(new PurchaseAmount("3500"));

        List<Lottery> lotteries = lotteryGame.purchaseLotteries();

        assertThat(lotteries.size()).isEqualTo(3);
    }

    @DisplayName("당첨 통계와 수익률을 계산해야 한다.")
    @Test
    void calculateWinningStatistics() {

    }
}
