package com.example.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.post.PostDAO;
import com.example.domain.PostVO;
import com.example.service.fcm.AndroidFCMNotification;
import com.example.service.fcm.AndroidFCMService;
import com.example.service.post.PostService;

@RestController
@RequestMapping("/api/post")
public class PostRestController {
	
	@Autowired
	PostDAO postDAO;
	
	@Autowired
	PostService postService;				// �Խñ� �� ���� ���� ����
	
	@Autowired
	AndroidFCMService androidFCMService;	// FCM (�ȵ���̵� �˸�) ���� ����
	
	// ���� insert �� �Խñ� insert
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public void insert(@RequestBody PostVO vo){
		postService.insert(vo);
	}
	
	// Ư�� ������ �Խñ� ���
	@RequestMapping("/list/{s_code}")
	public List<PostVO> list(@PathVariable String s_code) {
		return postDAO.list(s_code);
	}
	
	//Ư�� �Խñ� ����
	@RequestMapping("/read/{p_code}")
		public PostVO read(@PathVariable int p_code){
			PostVO vo = postDAO.read(p_code);
			return vo;
		}
	
	// �Խñ� ���� �� ���� ����
	@RequestMapping(value="/delete/{p_code}", method=RequestMethod.POST)
	public void delete(@PathVariable int p_code){
		postService.delete(p_code);
	}
	
	// FCM Push Notification
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/send")
	public @ResponseBody ResponseEntity<String> send() throws JSONException, InterruptedException {
		String notifications = AndroidFCMNotification.notificationJson();
		HttpEntity<String> request = new HttpEntity<>(notifications);
		CompletableFuture<String> pushNotification = androidFCMService.send(request);
		
        CompletableFuture.allOf(pushNotification).join();

        try {
            String firebaseResponse = pushNotification.get();
            return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
        } catch (InterruptedException e){
            logger.debug("PostRestController - send : got interrupted!");
            throw new InterruptedException();
        } catch (ExecutionException e){
            logger.debug("PostRestController - send : execution error!");
        }
        return new ResponseEntity<>("PostRestController - send : Push Notification ERROR!", HttpStatus.BAD_REQUEST);
	}
	
}
