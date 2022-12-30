package ex12;

import java.util.*;

public interface AccountDAO {
	public ArrayList<AccountVO> list();
	public void insert(AccountVO vo);
	public void update(AccountVO vo);
	public AccountVO read(int no);
	public void delete(int no);
}
