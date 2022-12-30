package ex02;

public class Sungjuk {										//클래스
	public static void grade() {							//메소드
		System.out.println("***************************** 성 적 표 *****************************");
		System.out.println("반\t이름\t국어\t영어\t수학\t총점\t평균");
		
		char ban1 = 'A', ban2 = 'B', ban3 = 'C';
		String name1 = "홍길동", name2 = "심청이", name3 = "강감찬";
		//국어, 영어, 수학
		int kor1 = 90, kor2 = 99, kor3 = 88;
		int eng1 = 88, eng2 = 80, eng3 = 79;
		int mat1 = 88, mat2 = 80, mat3 = 55;
		//총점
		int tot1 = kor1 + eng1 + mat1;
		int tot2 = kor2 + eng2 + mat2;
		int tot3 = kor3 + eng3 + mat3;
		//평균
		double avg1 = tot1 / 3.0;							//tot는 정수형 -> 정수형 / 실수형 = 실수형
		double avg2 = tot2 / 3.0;
		double avg3 = tot3 / 3.0;
		//출력
		System.out.println(ban1 + "\t" + name1 + "\t" + kor1 + "\t" + eng1 + "\t" + mat1 + "\t" + tot1 + "\t" + avg1);
		System.out.println(ban2 + "\t" + name2 + "\t" + kor2 + "\t" + eng2 + "\t" + mat2 + "\t" + tot2 + "\t" + avg2);
		System.out.println(ban3 + "\t" + name3 + "\t" + kor3 + "\t" + eng3 + "\t" + mat3 + "\t" + tot3 + "\t" + avg3);
		
		System.out.println("");
		
		System.out.println("**********매출 현황**********");
		System.out.println("상품명\t단가\t수량\t금액");
		
		String product1 = "냉장고", product2 = "세탁기";
		int price1 = 300, price2 = 150;
		int count1 = 3, count2 = 4;
		int productTot1 = price1 * count1;
		int productTot2 = price2 * count2;
		int totNum = count1 + count2;
		int totPrice = productTot1 + productTot2;
		
		System.out.println(product1 + "\t" + price1 + "\t" + count1 + "\t" + productTot1);
		System.out.println(product2 + "\t" + price2 + "\t" + count2 + "\t" + productTot2);
		
		System.out.println("----------------------------");
		System.out.println("합계\t\t" + totNum + "\t" + totPrice);
	}
}
