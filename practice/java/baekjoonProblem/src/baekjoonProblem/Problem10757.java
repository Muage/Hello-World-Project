package baekjoonProblem;

import java.math.*;
import java.util.*;

// ���� ( �⺻ ���� 1 �ܰ� )
// �� ���� A�� B�� �Է¹��� ����, A+B�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

// �Է�
// ù° �ٿ� A�� B�� �־�����. (0 < A,B < 1010000)

// ���
// ù° �ٿ� A+B�� ����Ѵ�.

// ���� �Է�
// 9223372036854775807 9223372036854775808

// ���� ���
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
