import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private static final String INPUT_MONEY_ONLY_NUMBER_MESSAGE = "[ERROR] 금액은 숫자로만 입력해주세요.";
    private static final String INPUT_BONUS_BALL_ONLY_NUMBER_MESSAGE = "[ERROR] 보너스 볼은 숫자로만 입력해주세요.";
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String REGEX_NUMBER = "^[0-9]*$";
    private static final String SPLIT_REGEX = ", ";

    private static final Scanner scanner = new Scanner(System.in);
    private static final Pattern onlyNumberPattern = Pattern.compile(REGEX_NUMBER);

    public static int askInputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        String input = scanner.nextLine();
        return convertToInt(input, INPUT_MONEY_ONLY_NUMBER_MESSAGE);
    }

    public static WinningNumber askInputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        String input = scanner.nextLine();
        String[] numbers = input.split(SPLIT_REGEX);
        return new WinningNumber(Arrays.stream(numbers)
            .map(Integer::parseInt)
            .map(number -> LottoNumber.from(number))
            .collect(Collectors.toList()));
    }

    public static LottoNumber askInputBonusBall() {
        System.out.println(INPUT_BONUS_BALL_MESSAGE);
        String input = scanner.nextLine();
        int number = convertToInt(input, INPUT_BONUS_BALL_ONLY_NUMBER_MESSAGE);
        LottoNumber bonusBall = LottoNumber.from(number);
        return bonusBall;
    }

    private static int convertToInt(String input, String errorMessage) {
        if (!onlyNumberPattern.matcher(input).matches()) {
            throw new IllegalArgumentException(errorMessage);
        }
        return Integer.parseInt(input);
    }
}
