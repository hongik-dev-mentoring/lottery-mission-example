package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Rank 는 ")
class RankTest {

    @DisplayName("알맞은 등수를 계산해야 한다.")
    @Test
    void calculateProperRank() {
        Rank expected = Rank.calculate(5, 1);

        assertThat(expected).isEqualTo(Rank.SECOND);
    }
}
