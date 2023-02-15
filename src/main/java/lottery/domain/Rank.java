package lottery.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 0, 2_000_000_000),
    SECOND(5, 1, 30_000_000),
    THIRD(5, 0, 1_500_000),
    FOURTH(4, 0, 50_000),
    FIFTH(3, 0, 5_000),
    NONE(2, 0, 0)
    ;

    private final int matchedNumbers;
    private final int matchedBonusNumber;
    private final int prize;

    Rank(final int matchedNumbers, final int matchedBonusNumber, final int prize) {
        this.matchedNumbers = matchedNumbers;
        this.matchedBonusNumber = matchedBonusNumber;
        this.prize = prize;
    }

    public static Rank calculate(final int matchedNumbers, final int matchedBonusNumber) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchedNumbers == matchedNumbers
                        && rank.matchedBonusNumber == matchedBonusNumber)
                .findFirst()
                .orElse(NONE);
    }
}
