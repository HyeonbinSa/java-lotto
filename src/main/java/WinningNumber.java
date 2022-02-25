import java.util.List;

public class WinningNumber {

    private static final String DUPLICATE_BONUS_BALL_MESSAGE = "[ERROR] 보너스 볼은 당첨 번호와 중복될수 없습니다.";
    private static final String WINNING_NUMBER_LENGTH_ONLY_SIX = "[ERROR] 당첨 번호는 6자리여야 합니다.";
    private static final String WINNING_NUMBER_RANGE_MESSAGE = "[ERROR] 당첨 번호는 1부터 45 이내의 숫자여야 합니다.";
    private static final String WINNING_NUMBER_DUPLICATE_MESSAGE = "[ERROR] 당첨 번호는 중복되지 않는 6개의 숫자여야 합니다.";

    private static final int LENGTH_STANDARD = 6;
    private static final int MIN_WINNING_NUMBER = 1;
    private static final int MAX_WINNING_NUMBER = 45;

    private final List<Integer> winningNumbers;

    public WinningNumber(List<Integer> winningNumbers) {
        checkWinningNumberLength(winningNumbers);
        checkAvailableRange(winningNumbers);
        checkDuplicatedWinningNumber(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public void checkBonusBall(int bonusBall) {
        if (winningNumbers.contains(bonusBall)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_BALL_MESSAGE);
        }
    }

    public boolean contains(int number) {
        return winningNumbers.contains(number);
    }

    private void checkWinningNumberLength(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LENGTH_STANDARD) {
            throw new IllegalArgumentException(WINNING_NUMBER_LENGTH_ONLY_SIX);
        }
    }

    private void checkAvailableRange(List<Integer> winningNumbers) {
        for (int winningNumber : winningNumbers) {
            isValidRange(winningNumber);
        }
    }

    private void isValidRange(int winningNumber) {
        if (winningNumber < MIN_WINNING_NUMBER || winningNumber > MAX_WINNING_NUMBER) {
            throw new IllegalArgumentException(WINNING_NUMBER_RANGE_MESSAGE);
        }
    }

    private void checkDuplicatedWinningNumber(List<Integer> winningNumbers) {
        int duplicatedCount = (int) winningNumbers.stream().distinct().count();
        if (duplicatedCount != winningNumbers.size()) {
            throw new IllegalArgumentException(WINNING_NUMBER_DUPLICATE_MESSAGE);
        }
    }
}
