# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---
### 1. 문자열 계산기

 - ### 기능 요구사항
   - 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
   - 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
   - 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
   - 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
   - 예를 들어 `2 + 3 * 4 / 2` 와 같은 문자열을 입력할 경우 `2 + 3 * 4 / 2` 실행 결과인 10을 출력해야 한다.

 - ### 기능 요구사항 분리

   - 덧셈 기능을 구현해야한다.
   - 뺄셈 기능을 구현해야한다.
   - 곱셈 기능을 구현해야한다.
   - 나눗셈 기능을 구현해야한다.
   - 나눗셈의 결과값이 정수로 떨어지지 않을 경우 IllegalArgumentException 을 반환한다.
   - 나눗셈을 할때 0값으로 나눌 경우 IllegalArgumentException 을 반환한다.
   - 입력값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException 을 반환한다.
   - 사칙연사 기호가 아닌 경우 IllegalArgumentException 을 반환한다.
   - 사칙연산은 입력값 순서에 따라 계산되도록 구현한다.

---
### 2. 로또

 - ### 기능 요구사항
   - 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
   - 로또 1장의 가격은 1000원이다.
   - 2등을 위해 추가 번호를 하나 더 추첨한다.
   - 당첨 통계에 2등도 추가해야한다.
   - 현재 로또 생성기는 자동 생성 기능만 제공한다. 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야햔다.
   - 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 한다.

 - ### 기능 요구사항 분리
   - 기능
     - 입력한 금액에서 1000 으로 나눈 값만큼 로또를 생성한다.
       - 로또 번호는 자동을 생성된다.
       - 로또 하나당 6개의 번호를 가지고 있어야 한다.
       - 로또 번호의 범위는 1 ~ 45 까지이다.
     - 로또 번호가 당첨 번호와 비교해서 일치한 개수에 따라 당첨금이 정해진다.
       - 3개가 일치하면 당첨금은 5000 원이다.
       - 4개가 일치하면 당첨금은 50000 원을이다.
       - 5개가 일치하면 보너스볼이 일치하지 않으면 당첨금은 1500000 원이다.
       - 5개가 일치하고 보너스볼이 일치하면 30000000 원이다.
       - 6개가 일치하면 당첨금은 2000000000 원이다.
     - 총 수익률을 구할 수 있어야한다.
     - 로또 번호를 수동으로 지정해서 로또를 생성할 수 있어야한다.
     - 모든 예외처리를 통해 에러가 발생하지 않아야한다.
     - 입력받은 수동 로또번호 정보를 통해 해당하는 자동로또와 수동로또를 생성해야한다.
   - View
     - 로또 구입금액을 입력할 수 있어야한다.
     - 발급된 로또 정보들을 보여주어야 한다.
     - 당첨 번호를 입력받을 수 있어야한다.
     - 입력받은 당첨번호와 발급받은 로또 번호를 비교해 일치하는 정보를 보여주어야한다.
     - 총 수익률을 보여주어야한다.
     - 보너스 볼을 입력할 수 있어야 한다.
     - 수동으로 구매할 로또 수를 입력할 수 있어야 한다.
     - 수동으로 구매할 번호를 입력할 수 있어야한다.
       - 수동 로또 수만큼 구매 번호를 입력받는다.
     - 수동, 자동으로 구매한 로또 번호를 보여주어야한다.