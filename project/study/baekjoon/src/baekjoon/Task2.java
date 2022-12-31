package baekjoon;

import java.util.Scanner;
import java.io.*;

public class Task2 {
	public static void execute() {
		Scanner s = new Scanner(System.in);
		
//		int compareA = s.nextInt();
//		int compareB = s.nextInt();
//		
//		if(compareA > compareB) {
//			System.out.println(">");
//		} else if(compareA < compareB) {
//			System.out.println("<");
//		} else {
//			System.out.println("==");
//		}
//		System.out.println("--------------------");
//		
//		int score = s.nextInt();
//		if(score >= 90 && score <= 100) {
//			System.out.println("A");
//		} else if(score >= 80 && score <= 89) {
//			System.out.println("B");
//		} else if(score >= 70 && score <= 79) {
//			System.out.println("C");
//		} else if(score >= 60 && score <= 69) {
//			System.out.println("D");
//		} else {
//			System.out.println("F");
//		}
//		System.out.println("--------------------");
//		
//		int year = s.nextInt();
//		
//		if((year % 4 == 0) && ((year % 400 == 0) || (year % 100 != 0))) {
//			System.out.println("1");
//		} else {
//			System.out.println("0");
//		}
//		System.out.println("--------------------");
//		
//		int coorx = s.nextInt();
//		int coory = s.nextInt();
//		
//		if(coorx > 0 && coory > 0) {
//			System.out.println("1");
//		} else if(coorx < 0 && coory > 0) {
//			System.out.println("2");
//		} else if(coorx < 0 && coory < 0) {
//			System.out.println("3");
//		} else {
//			System.out.println("4");
//		}
//		System.out.println("--------------------");
//		
//		int hour = s.nextInt();
//		int min = s.nextInt();
//		
//		if(hour == 24) {
//			hour = 0;
//		} else if(hour < 0) {
//			hour = 24;
//		}
//		
//		int nmin = min - 45;
//		
//		if(nmin == 60) {
//			hour++;
//			nmin = 0;
//		} else if(nmin < 0) {
//			hour--;
//			nmin = nmin + 60;
//			if(hour < 0) {
//				hour =23;
//			}
//		}
//		System.out.println(hour + " " + nmin);
//		System.out.println("--------------------");
//		
//		int cookHour = s.nextInt();
//		int cookMin = s.nextInt();
//		int cookTime = s.nextInt();
//		
//		cookHour = cookHour + cookTime / 60;
//		cookMin = cookMin + cookTime % 60;
//		
//		if(cookHour > 23) {
//			cookHour = cookHour % 24;
//		}
//		if(cookMin >= 60) {
//			cookHour++;
//			cookMin = cookMin - 60;
//			if(cookHour > 23) {
//				cookHour = cookHour % 24;
//			}
//		}
//		System.out.println(cookHour + " " + cookMin);
//		System.out.println("--------------------");
//		
//		int dice1 = s.nextInt();
//		int dice2 = s.nextInt();
//		int dice3 = s.nextInt();
//		
//		if((dice1 == dice2) && (dice1 == dice3)) {
//			System.out.println(10000 + dice1 * 1000);
//		} else if((dice1 == dice2) || (dice1 == dice3)) {
//			System.out.println(1000 + dice1 * 100);
//		} else if((dice2 == dice3)) {
//			System.out.println(1000 + dice2 * 100);
//		} else if((dice1 != dice2) && (dice1 != dice3) && (dice2 != dice3)) {
//			if((dice1 > dice2) && (dice1 > dice3)) {
//				System.out.println(dice1 * 100);
//			} else if((dice2 > dice1) && (dice2 > dice3)) {
//				System.out.println(dice2 * 100);
//			} else {
//				System.out.println(dice3 * 100);
//			}
//		}
	}
}
