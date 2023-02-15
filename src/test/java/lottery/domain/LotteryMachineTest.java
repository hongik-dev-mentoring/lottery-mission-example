package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LotteryMachine 은 ")
class LotteryMachineTest {

    @DisplayName("로또 한 장을 생산한다.")
    @Test
    void generateLottery() {
        final Lottery lottery = LotteryMachine.generate();

        assertThat(lottery.getNumbers().size()).isEqualTo(6);
    }
}
