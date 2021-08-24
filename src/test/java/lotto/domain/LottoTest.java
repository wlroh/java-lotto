package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTest {
	@DisplayName(value = "로또 번호의 유효 범위가 1부터 45까지인지 테스트")
	@Test
	void betweenOneAndFortyFive() {
		List<Integer> expect = new ArrayList<>();
		for (int i = 1; i <= 45; i++) {
			expect.add(i);
		}

		LottoCard lottoCard = LottoCard.getInstance();
		Lotto lotto = lottoCard.issue();
		List<Integer> lottoNumbers = lotto.getNumbers()
			.stream()
			.map(Number::getValue)
			.collect(Collectors.toList());

		assertThat(expect).containsAll(lottoNumbers);
	}

	@DisplayName(value = "로또 번호의 유효 범위를 벗어나면 예외를 던짐")
	@ValueSource(ints = {-1, 0, 46})
	@ParameterizedTest
	void notBetweenOneAndFortyFive(int value) {
		assertThatThrownBy(() -> new Number(value))
			.isInstanceOf(RuntimeException.class);
	}
}
