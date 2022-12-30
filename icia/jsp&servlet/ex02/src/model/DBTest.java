package model;

import java.util.*;

public class DBTest {

	public static void main(String[] args) {
		UserDAO userDAO = new UserDAO();
		ArrayList<UserVO> array = userDAO.list(2);
		for(UserVO vo : array) {
			System.out.println(vo.toString());
		}
	}
}
