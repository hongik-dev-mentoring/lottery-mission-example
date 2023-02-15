package lottery.domain;

import static lottery.common.Fixture.BONUS_NUMBER;
import static lottery.common.Fixture.LOTTERY_NUMBERS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("당첨 번호와 보너스 볼 숫자가 같으면 에러를 발생시킨다.")
    @Test
    void duplicatedNumberWithBonusNumber() {
        assertThatThrownBy(() -> new WinningLottery(new Lottery(LOTTERY_NUMBERS), 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 볼의 숫자와 당첨 번호가 중복일 수 없습니다.");
    }
}
