package backjoonProblem;

import java.util.*;

public class Problem03003 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int find[] = new int[6];
		for(int i = 0; i < 6; i++) {
			find[i] = scanner.nextInt();
		}
		
		int chess[] = {1, 1, 2, 2, 2, 8};
		
		int king	= chess[0] - find[0];
		int queen	= chess[1] - find[1];
		int rook	= chess[2] - find[2];
		int bishop	= chess[3] - find[3];
		int knight	= chess[4] - find[4];
		int pawn	= chess[5] - find[5];
		
		System.out.printf("%d %d %d %d %d %d", king, queen, rook, bishop, knight, pawn);
	}

}