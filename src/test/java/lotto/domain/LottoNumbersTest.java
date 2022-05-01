package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    @Test
    @DisplayName("LottoNumbers 3,1,5 순서의 리스트로 생성하면 1,3,5로 정렬되여 생성된다.")
    void sort() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(5));

        assertThat(new LottoNumbers(lottoNumbers).toList()).containsExactly(new LottoNumber(1), new LottoNumber(3), new LottoNumber(5));
    }

    @Test
    @DisplayName("fullLottoNumbers 호출 시 1 ~ 45 번까지의 모든 로또 번호가 반환된다.")
    void fullLottoNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }

        assertThat(LottoNumbers.fullLottoNumbers()).isEqualTo(new LottoNumbers(lottoNumbers));
    }

    @Test
    @DisplayName("1,2,3을 가지고 있는 LottoNumbers와 2,3,4를 가지고 있는 List와의 matchCount는 2이다.")
    void matchCount() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));

        List<LottoNumber> lottoNumbers2 = new ArrayList<>();
        lottoNumbers2.add(new LottoNumber(2));
        lottoNumbers2.add(new LottoNumber(3));
        lottoNumbers2.add(new LottoNumber(4));

        assertThat(new LottoNumbers(lottoNumbers).matchCount(lottoNumbers2)).isEqualTo(2);
    }
}