package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("WinningLottery 는 ")
class WinningLotteryTest {

    @DisplayName("당첨 등수를 계산한다.")
    @Test
    void calculateRank() {
        WinningLottery winningLottery = new WinningLottery(new Lottery(List.of(1, 2, 3, 4, 5, 6)), 7);

        Rank actual = winningLottery.calculateRank(new Lottery(List.of(1, 2, 3, 4, 5, 6)));

        assertThat(actual).isEqualTo(Rank.FIRST);
    }
}
