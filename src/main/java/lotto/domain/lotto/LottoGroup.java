package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGroup {

    private final List<LottoNumbers> lotties;

    public LottoGroup(List<LottoNumbers> lotties) {
        this.lotties = new ArrayList<>(lotties);
    }

    public int getCount() {
        return lotties.size();
    }

    public List<LottoNumbers> getLotties() {
        return Collections.unmodifiableList(lotties);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), lotties.stream()
            .map(LottoNumbers::toString).collect(Collectors.toList()));
    }
}