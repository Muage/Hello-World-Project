package com.example.controller;

import java.util.HashMap;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.user.UserDAO;
import com.example.domain.UserVO;
import com.example.service.user.UserService;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
	
	// UserDAO ����
	@Autowired
	UserDAO userDAO;
	
	// UserService ����	
	@Autowired
	UserService userService;
	
	// ��й�ȣ ��ȣȭ
	@Autowired
	PasswordEncoder encoder;
	
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public void insert(@RequestBody UserVO userVO) {
//		userVO.setU_code(userDAO.newCode());
		userVO.setU_pass(encoder.encode(userVO.getU_pass()));
//		System.out.println(userVO.toString());
		userDAO.insert(userVO);
	}
	
	// ���� �˻� (��)
	@RequestMapping("/list")
	public HashMap<String, Object> list(String column, String query, int page, int num) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("list", userDAO.list(column, query, page, num));
		map.put("total", userDAO.total(column, query));
		return map;
	}
	
	// �ڵ��  Ư�� ������ ���� �б� (��)
	@RequestMapping("/read/{u_code}")
	public UserVO read(@PathVariable String u_code) {
		UserVO vo = userDAO.read(u_code);
//			System.out.println("UserRestController - read : " + vo.toString());
		return vo;
	}
	
	// ���� ���� ���̺� ���� �� ���� ���
	@RequestMapping(value="/delete/{u_code}", method=RequestMethod.POST)
	public void delUser(@PathVariable String u_code){
		userService.delUser(u_code);
	}
	
	// ���� ���̺� �ִ� ���� ����
	@RequestMapping(value="/recover/{u_code}", method=RequestMethod.POST)
	public void reUser(@PathVariable String u_code){
		userService.reUser(u_code);
	}
	
	// ���� ���� ���̺��� 14�� �̻� ���� ���� ���� (��������)
	@RequestMapping(value="/del_user", method = RequestMethod.POST)
	public void del_user(){
//		System.out.println("UserRestController - del_user check");
		userService.del_user();
	}
	
	// �α��� üũ
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public HashMap<String, Object> login(@RequestBody UserVO vo) {
//		System.out.println("UserRestController - login : " + vo.toString());
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		int result = 0;
		int u_type = 0;
		String u_id = "";
		String u_code = "";
		UserVO readvo = userDAO.loginRead(vo.getU_id());
		if (readvo != null) {
			if (vo.getU_pass().equals(readvo.getU_pass())) {
				result = 2;
				u_type = readvo.getU_type();
				u_id = readvo.getU_id();
				u_code = readvo.getU_code();
			} else {
				result = 1;
			}
		}
		map.put("check", result);
		map.put("u_type", u_type);
		map.put("u_id", u_id);
		map.put("u_code", u_code);
//		System.out.println("UserRestController - login : " + map);
		return map;
	}
	
	// �ȵ���̵� ȸ������
	@RequestMapping(value="/and_insert", method=RequestMethod.POST)
	public int and_insert(@RequestBody UserVO userVO) {
//		System.out.println("UserRestController - and_insert : " + userVO.toString());
		int result = 0;
		
		UserVO getUserVO = userDAO.loginRead(userVO.getU_id());	// ���� ���̵� ���翩�� Ȯ��
		if(getUserVO != null) {	// ���� ���̵� ���� ��
				System.out.println("UserRestController - and_insert :: ���� ���̵� ����");
		} else {	// ���� ���̵� ���� ��
			userVO.setU_code(userDAO.newCode());
			userVO.setU_pass(encoder.encode(userVO.getU_pass()));
			userDAO.insert(userVO);
			result = 1;
		}
		return result;
	}
	
	// �ȵ���̵� īī�� ȸ������
	@RequestMapping(value="/and_kakao_insert", method=RequestMethod.POST)
	public int and_kakao_insert(@RequestBody UserVO userVO) {
//		System.out.println("UserRestController - and_kakao_insert : " + userVO.toString());
		int result = 0;
		
		UserVO getUserVO = userDAO.loginRead(userVO.getU_id());	// ���� ���̵� ���翩�� Ȯ��
		try {
			if(getUserVO != null) {	// ���� ���̵� ���� ��
					System.out.println("UserRestController - and_kakao_insert :: ���� ���̵� ����");
			} else {	// ���� ���̵� ���� ��
				userVO.setU_code(userDAO.newKakaoCode(userVO.getU_code()));	// īī�� ȸ������ ����� �ڵ� �ο�
				userVO.setU_pass(encoder.encode(userVO.getU_pass()));		// ��й�ȣ ��ȣȭ
				userDAO.insert(userVO);
				result = 2;
			}
			return result;
		} catch(Exception e) {
			// ���� īī�� �ڵ� ���� ��
			System.out.println("UserRestController - and_kakao_insert :: �̹� ȸ������ �� ������Դϴ�");
			result = 1;
			return result;
		}
	}
	
	// �ȵ���̵� �α��� üũ
	@RequestMapping(value="/and_login", method=RequestMethod.POST)
	public UserVO and_login(@RequestBody UserVO userVO) {
		UserVO getUserVO = userDAO.loginRead(userVO.getU_id());
		
		if(getUserVO != null) {
			if (encoder.matches(userVO.getU_pass(), getUserVO.getU_pass())) {
				System.out.println("UserRestController - and_login :: �α��� ����");
				return getUserVO;
			} else {
				System.out.println("UserRestController - and_login :: ��й�ȣ ����ġ");
				return null;
			}
		} else {
			System.out.println("UserRestController - and_login :: �Էµ� ���̵�� ��ġ�ϴ� ���̵� ����");
			return null;
		}
	}
	
	// �ȵ���̵� ȸ������ �� ���� ����
	@RequestMapping("/sendAuthSMS")
	public String sendAuthSMS(String phoneNumber) {
		Random randomNum = new Random();	// ���� ����
		String authNum = "";
		
		for(int i = 0; i < 6; i++) {	// ���� ��ȣ 6�ڸ��� ����
			String random = Integer.toString(randomNum.nextInt(10));
			authNum += random;
		}
		
//		System.out.println("UserRestController - sendAuthSMS :: ������ ��ȣ : " + phoneNumber);
		System.out.println("UserRestController - sendAuthSMS :: ���� ��ȣ : " + authNum);
		userService.authPhoneNumber(phoneNumber, authNum);
		
		return authNum;
	}
	
}
