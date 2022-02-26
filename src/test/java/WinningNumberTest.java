import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WinningNumberTest {

    private WinningNumber winningNumber;

    @Test
    @DisplayName("당첨 번호가 6자리가 아니면 예외 발생")
    public void checkWinningNumberIs6Test() {
        assertThrows(IllegalArgumentException.class,
            () -> new WinningNumber(List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3), LottoNumber.from(4), LottoNumber.from(5))));
    }

    @Test
    @DisplayName("당첨 번호에 보너스 볼이 있으면 예외 발생")
    public void checkBonusBallInWinningNumbersTest() {
        winningNumber = new WinningNumber(List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3), LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6)));

        LottoNumber bonusBall = LottoNumber.from(3);
        assertThrows(IllegalArgumentException.class,
            () -> winningNumber.checkBonusBall(bonusBall));
    }

    @Test
    @DisplayName("당첨 번호에 1부터 45 이외의 숫자가 들어오면 예외 발생")
    public void checkAvailableRangeTest() {
        assertThrows(IllegalArgumentException.class,
            () -> winningNumber = new WinningNumber(List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3), LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(46))));
    }

    @Test
    @DisplayName("당첨 번호에 중복된 숫자가 존재할 경우 예외 발생")
    public void checkDuplicatedWinningNumberTest() {
        assertThrows(IllegalArgumentException.class,
            () -> winningNumber = new WinningNumber(List.of(LottoNumber.from(1), LottoNumber.from(44), LottoNumber.from(3), LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(44))));
    }
}
