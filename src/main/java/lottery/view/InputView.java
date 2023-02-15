package lottery.view;

import java.util.Scanner;
import lottery.view.dto.WinningNumberDto;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.next();
    }

    public static WinningNumberDto inputWinningRate() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine();

        final String winningNumbers = scanner.nextLine();

        System.out.println("보너스 볼을 입력해 주세요.");
        final String bonusNumber = scanner.next();

        return WinningNumberDto.of(winningNumbers, bonusNumber);
    }
}
