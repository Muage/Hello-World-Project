package ex10;

import java.util.ArrayList;

public interface ScoreDAO {
	//목록출력
	public ArrayList<ScoreVO> list(int no, ArrayList<ScoreVO> array);
	
	//입력
	public void insert(ScoreVO vo, ArrayList<ScoreVO> array);
	
	//검색출력
	public ScoreVO read(int no, ArrayList<ScoreVO> array);
	
	//수정
	public void update(ScoreVO vo, ArrayList<ScoreVO> array);
	
	//삭제
	public void delete(int no, ArrayList<ScoreVO> array);
}
