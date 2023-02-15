package lottery.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class PurchaseAmount {

    private static final int LOTTERY_PRICE = 1000;
    private final static String INVALID_AMOUNT_ERROR = "구입 금액은 양의 정수여야 합니다.";
    private static final String POSITIVE_NUMBER_REGX = "^[1-9]\\d*";
    private static final Pattern COMPILED_POSITIVE_NUMBER_REGX = Pattern.compile(POSITIVE_NUMBER_REGX);

    private final int amount;

    public PurchaseAmount(final String amount) {
        validateAmount(amount);
        this.amount = Integer.parseUnsignedInt(amount);
    }

    private void validateAmount(final String amount) {
        if (!COMPILED_POSITIVE_NUMBER_REGX.matcher(amount).matches()) {
            throw new IllegalArgumentException(INVALID_AMOUNT_ERROR);
        }
    }

    public int calculateLotteries() {
        return amount / LOTTERY_PRICE;
    }

    public double calculateWinningRate(final int winningAmount) {
        return (double) winningAmount / amount;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PurchaseAmount)) {
            return false;
        }
        final PurchaseAmount that = (PurchaseAmount) o;
        return amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "PurchaseAmount{" +
                "amount=" + amount +
                '}';
    }
}
