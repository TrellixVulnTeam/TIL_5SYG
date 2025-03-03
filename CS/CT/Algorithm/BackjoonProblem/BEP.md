# 손익분기점

## 문제

월드전자는 노트북을 제조하고 판매하는 회사이다. 노트북 판매 대수에 상관없이 매년 임대료, 재산세, 보험료, 급여 등 A만원의 고정 비용이 들며, 한 대의 노트북을 생산하는 데에는 재료비와 인건비 등 총 B만원의 가변 비용이 든다고 한다.

예를 들어 A=1,000, B=70이라고 하자. 이 경우 노트북을 한 대 생산하는 데는 총 1,070만원이 들며, 열 대 생산하는 데는 총 1,700만원이 든다.

노트북 가격이 C만원으로 책정되었다고 한다. 일반적으로 생산 대수를 늘려 가다 보면 어느 순간 총 수입(판매비용)이 총 비용(=고정비용+가변비용)보다 많아지게 된다. 최초로 총 수입이 총 비용보다 많아져 이익이 발생하는 지점을 손익분기점(BREAK-EVEN POINT)이라고 한다.

A, B, C가 주어졌을 때, 손익분기점을 구하는 프로그램을 작성하시오.

## 입력

첫째 줄에 A, B, C가 빈 칸을 사이에 두고 순서대로 주어진다. A, B, C는 21억 이하의 자연수이다.

## 출력

첫 번째 줄에 손익분기점 즉 최초로 이익이 발생하는 판매량을 출력한다. 손익분기점이 존재하지 않으면 -1을 출력한다.

## 예제 입력 1 복사

```
1000 70 170
```

## 예제 출력 1 복사

```
11
```

## 풀이

* 노트북 가격 측정시 다음 식이 만족하도록 하면 손익분기점이 출력된다.

  ```
  고정비용 + 생산비 * N < 측정비 * N
  
  고정비용 < (측정비 - 생산비) * N
  
  고정비용 / (측정비 - 생산비) < N 
  위의 식을 만족하는 첫 번째 N 값이 정답.
  ```

* 마지막 줄에 따라서 N = 고정비용 / (측정비 - 생산비)  + 1 로 계산할 수 있다.

* 각 숫자는 21억 미만의 자연수 이므로 3 변수 모두 int 값으로 선언하여도 값이 범위를 넘어서지 않는다.

```java
package backjoon;

import java.util.Scanner;

public class BEP {
	// 백준 손익분기점 문제. https://www.acmicpc.net/problem/1712
	public static void main(String[] args) {
		int pixedCost;
		int cost;
		int price;

		Scanner sc = new Scanner(System.in);
		System.out.println("고정: ");
		pixedCost = sc.nextInt();
		System.out.println("생산: ");
		cost = sc.nextInt();
		System.out.println("가격: ");
		price = sc.nextInt();
		
		if (cost >= price) {
			System.out.println(-1);
		} else {
			System.out.println(pixedCost / (price-cost) +1);
		}
  }
}
```

* 출력

![image-20200726165958523](BEP.assets/image-20200726165958523.png)
