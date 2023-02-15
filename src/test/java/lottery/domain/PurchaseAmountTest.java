package lottery.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
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
}
