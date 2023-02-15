package lottery.view.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lottery.domain.Lottery;
import lottery.domain.WinningLottery;

public class WinningNumberDto {

    private static final String WINNING_NUMBER_DELIMITER = ", ";

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    private WinningNumberDto(final List<Integer> winningNumbers, final int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumberDto of(final String rawWinningNumbers, final String bonusNumber) {
        final List<Integer> winningNumbers = Arrays.stream(rawWinningNumbers.split(WINNING_NUMBER_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new WinningNumberDto(winningNumbers, Integer.parseInt(bonusNumber));
    }

    public static WinningLottery toEntity(WinningNumberDto winningNumberDto) {
        return new WinningLottery(new Lottery(winningNumberDto.getWinningNumbers()), winningNumberDto.getBonusNumber());
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public String toString() {
        return "WinningNumberDto{" +
                "winningNumbers=" + winningNumbers +
                ", bonusNumber=" + bonusNumber +
                '}';
    }
}
