package lottery.controller;

import java.util.List;
import lottery.domain.Lottery;
import lottery.domain.LotteryGame;
import lottery.domain.LotteryMachineFactory;
import lottery.domain.PurchaseAmount;
import lottery.dto.WinningStatisticsDto;
import lottery.view.InputView;
import lottery.view.OutputView;
import lottery.view.dto.WinningNumberDto;

public class LotteryController {

    public void startGame() {
        final String amount = InputView.inputPurchaceAmount();
        final LotteryGame lotteryGame = new LotteryGame(new PurchaseAmount(amount));
        List<Lottery> lotteries = lotteryGame.purchaseLotteries(new LotteryMachineFactory());

        OutputView.printPurchasedLotteries(lotteries);
        WinningNumberDto winningNumberDto = InputView.inputWinningRate();

        WinningStatisticsDto winningStatisticsDto = lotteryGame.calculateWinningStatistics(
                WinningNumberDto.toEntity(winningNumberDto));
        OutputView.printWinningStatistics(winningStatisticsDto);
    }
}
