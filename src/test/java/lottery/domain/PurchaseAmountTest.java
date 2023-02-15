package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("PurchaseAmount 는 ")
class PurchaseAmountTest {

    @DisplayName("입력한 금액이 올바르지 않으면 에러를 발생시킨다.")
    @ParameterizedTest(name = "{index} {displayName} amount={0}")
    @ValueSource(strings = {"0", "-1"})
    void isValidAmount(final String amount) {
        assertThatThrownBy(() -> new PurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액은 양의 정수여야 합니다.");
    }

    @DisplayName("입력한 금액을 이용해 구입 가능한 로또 갯수를 산출한다.")
    @ParameterizedTest
    @CsvSource(value = {"2000, 2", "1400, 1"})
    void calculateLotteries(final String amount, final int expected) {
        final PurchaseAmount purchaseAmount = new PurchaseAmount(amount);

        assertThat(purchaseAmount.calculateLotteries()).isEqualTo(expected);
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void calculateWinningRate() {
        final PurchaseAmount purchaseAmount = new PurchaseAmount("2000");

        assertThat(purchaseAmount.calculateWinningRate(1000)).isEqualTo(0.5);
    }
}
