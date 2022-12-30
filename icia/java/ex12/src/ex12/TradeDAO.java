package ex12;

import java.io.*;
import java.util.*;

public class TradeDAO {
	File file = new File("C:/Data/java/ex12/trade.txt");
	//거래내역등록
	public void insert(TradeVO vo) {
		try {
			FileWriter writer = new FileWriter(file, true);
		
			writer.write(vo.getNo() + "|" + vo.getDate() + "|" + vo.getType() + "|" + vo.getAmount() + "\n");
			writer.flush();
			writer.close();
		} catch(Exception e) {
			System.out.println("insert : " + e.toString());
		}
	}
	
	//특정계좌의 거래내역 출력
	public ArrayList<TradeVO> list(int no) {
		ArrayList<TradeVO> array = new ArrayList<>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			
			while((line = reader.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "|");
				int lineNo = Integer.parseInt(st.nextToken());
				
				if(lineNo == no) {
					TradeVO vo = new TradeVO();
					vo.setNo(lineNo);					
					vo.setDate(st.nextToken());
					vo.setType(st.nextToken());
					vo.setAmount(Integer.parseInt(st.nextToken()));
					
					array.add(vo);
				}
			}
		} catch(Exception e) {
			System.out.println("list : " + e.toString());
		}
		
		return array;
	}
}
