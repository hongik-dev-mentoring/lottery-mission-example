package lottery.domain;

import java.util.Objects;

public class WinningLottery {

    private final Lottery lottery;
    private final int bonusNumber;

    public WinningLottery(final Lottery lottery, final int bonusNumber) {
        validateWinningLottery(lottery, bonusNumber);
        this.lottery = lottery;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningLottery(final Lottery lottery, final int bonusNumber) {
        if (lottery.containNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 볼의 숫자와 당첨 번호가 중복일 수 없습니다.");
        }
    }

    public Rank calculateRank(final Lottery purchasedLottery) {
        final int sameNumbers = lottery.findTheNumberOfSameNumbers(purchasedLottery);
        final boolean isSameWithBonusNumber = isSameWithBonusNumber(purchasedLottery);
        return Rank.calculate(sameNumbers, isSameWithBonusNumber);
    }

    private boolean isSameWithBonusNumber(final Lottery purchasedLottery) {
        return purchasedLottery.getNumbers()
                .stream()
                .anyMatch(number -> number == bonusNumber);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WinningLottery)) {
            return false;
        }
        final WinningLottery that = (WinningLottery) o;
        return bonusNumber == that.bonusNumber && Objects.equals(lottery, that.lottery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottery, bonusNumber);
    }

    @Override
    public String toString() {
        return "WinningLottery{" +
                "lottery=" + lottery +
                ", bonusNumber=" + bonusNumber +
                '}';
    }
}
