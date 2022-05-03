package lotto.domain;

import lotto.dto.input.BuyerData;
import lotto.dto.input.LastWinningData;
import lotto.dto.result.WinningStats;
import lotto.util.Calculator;

public class LottoBuyer {

    private static final int LOTTO_PRICE = 1000;

    private final int purchaseAmount;
    private Lottos lottos;

    public LottoBuyer(BuyerData buyerData) {
        this(buyerData.purchaseAmount());
    }

    public LottoBuyer(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void buyLottos() {
        lottos = new LottoStore().createLottos(lottoCount());
    }

    private int lottoCount() {
        return purchaseAmount / LOTTO_PRICE;
    }

    public WinningStats confirmLottos(LastWinningData lastWinningData) {
        lottos.confirmAll(lastWinningData.toWinningLottoNumbers());
        return WinningStats.of(this);
    }

    public double calculateProfitRate() {
        return Calculator.divide(lottos.calculateTotalWinPrice(), purchaseAmount);
    }

    public Lottos lottos() {
        return lottos;
    }
}
