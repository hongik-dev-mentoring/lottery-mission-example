package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Lottery 는 ")
class LotteryTest {

    @TestInstance(Lifecycle.PER_CLASS)
    @DisplayName("로또를 생성할 때.")
    @Nested
    class LotteryCreationTest {

        @DisplayName("로또 생성 조건을 만족하면 생성한다.")
        @Test
        void createLotterySuccess() {
            Lottery lottery = Lottery.generate();

            assertThat(lottery.getNumbers().size()).isEqualTo(6);
        }

        @DisplayName("로또 숫자가 조건에 맞지 않으면 에러를 던진다.")
        @ParameterizedTest(name = "{index} {displayName} lotteryNumber={0}, errorMessage={1}")
        @MethodSource("createLotteryFailSource")
        void createLotteryFail(final List<Integer> lotteryNumbers, final String errorMessage) {
            assertThatThrownBy(() -> new Lottery(lotteryNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(errorMessage);
        }

        private Stream<Arguments> createLotteryFailSource() {
            return Stream.of(
                    Arguments.of(List.of(1, 2, 3, 4, 5), "로또 사이즈는 6이어야 합니다."),
                    Arguments.of(List.of(1, 2, 3, 4, 4, 5), "로또 숫자는 중복일 수 없습니다."),
                    Arguments.of(List.of(0, 1, 2, 3, 4, 5), "로또 숫자는 1-45 사이 숫자여야 합니다."),
                    Arguments.of(List.of(1, 2, 3, 4, 5, 46), "로또 숫자는 1-45 사이 숫자여야 합니다.")
            );
        }
    }
}
