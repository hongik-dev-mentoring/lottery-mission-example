package lottery.domain;

import static lottery.common.Fixture.BONUS_NUMBER;
import static lottery.common.Fixture.LOTTERY_NUMBERS;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("WinningLottery 는 ")
class WinningLotteryTest {

    @DisplayName("당첨 등수를 계산한다.")
    @Test
    void calculateRank() {
        WinningLottery winningLottery = new WinningLottery(new Lottery(LOTTERY_NUMBERS), BONUS_NUMBER);

        Rank actual = winningLottery.calculateRank(new Lottery(LOTTERY_NUMBERS));

        assertThat(actual).isEqualTo(Rank.FIRST);
    }
}
