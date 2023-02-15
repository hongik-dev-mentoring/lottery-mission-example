package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Lottery 는 ")
class LotteryTest {

    @DisplayName("로또를 생성한다.")
    @Test
    void createLotteryTest() {
        Lottery lottery = Lottery.generate();

        assertThat(lottery.getNumbers().size()).isEqualTo(6);
    }
}
