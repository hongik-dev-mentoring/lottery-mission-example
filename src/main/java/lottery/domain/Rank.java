package lottery.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, true, 50_000),
    FIFTH(3, false, 5_000),
    NONE(2, false, 0);

    private final int matchedNumbers;
    private final boolean hasBonusNumber;
    private final int prize;

    Rank(final int matchedNumbers, final boolean hasBonusNumber, final int prize) {
        this.matchedNumbers = matchedNumbers;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
    }

    public static Rank calculate(final int matchedNumbers, final boolean hasBonusNumber) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchedNumbers == matchedNumbers
                        && rank.hasBonusNumber == hasBonusNumber)
                .findFirst()
                .orElse(NONE);
    }

    public int getMatchedNumbers() {
        return matchedNumbers;
    }

    public int getPrize() {
        return prize;
    }
}
