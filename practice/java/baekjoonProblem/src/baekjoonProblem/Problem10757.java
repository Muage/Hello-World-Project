package baekjoonProblem;

import java.math.*;
import java.util.*;

// 문제 ( 기본 수학 1 단계 )
// 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 A와 B가 주어진다. (0 < A,B < 1010000)

// 출력
// 첫째 줄에 A+B를 출력한다.

// 예제 입력
// 9223372036854775807 9223372036854775808

// 예제 출력
// 18446744073709551615

public class Problem10757 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		BigInteger a = new BigInteger(scanner.next());
		BigInteger b = new BigInteger(scanner.next());
		System.out.println(a.add(b));
		
		scanner.close();
	}

}
