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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.post.PostDAO;
import com.example.domain.PostVO;
import com.example.service.post.AndroidFCMNotification;
import com.example.service.post.AndroidFCMService;

@RestController
@RequestMapping("/api/post")
public class PostRestController {
	
	@Autowired
	PostDAO postDAO;
	
	@Autowired
	AndroidFCMService androidFCMService;
	
	@RequestMapping("/list/{s_code}")
	public List<PostVO> list(@PathVariable String s_code) {
		return postDAO.list(s_code);
	}
	
	// FCM Push Notification
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/send")
	public @ResponseBody ResponseEntity<String> send() throws JSONException, InterruptedException {
		String notifications = AndroidFCMNotification.notificationJson();
		HttpEntity<String> request = new HttpEntity<>(notifications);
		CompletableFuture<String> pushNotification = androidFCMService.send(request);
		
        CompletableFuture.allOf(pushNotification).join();

        try{
            String firebaseResponse = pushNotification.get();
            return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
        }
        catch (InterruptedException e){
            logger.debug("PostRestController - send : got interrupted!");
            throw new InterruptedException();
        }
        catch (ExecutionException e){
            logger.debug("PostRestController - send : execution error!");
        }

        return new ResponseEntity<>("PostRestController - send : Push Notification ERROR!", HttpStatus.BAD_REQUEST);
	}
	
//	@RequestMapping(value="/sendMessage", method=RequestMethod.POST)
//	// send message to android
//	public String sendMessage(int requestId, String registrationToken) throws FirebaseMessagingException {
//		Message message = Message.builder()
//				.setAndroidConfig(AndroidConfig.builder()
//						.setTtl(3600 * 1000)
//						.setPriority(AndroidConfig.Priority.HIGH)
//						.setRestrictedPackageName("com.icia.friend")
//						.setDirectBootOk(true)
//						.setNotification(AndroidNotification.builder()	// �˸� ����
//								.setTitle("�׽�Ʈ")						// �˸� ���� ����
//								.setBody("FCMService �׽�Ʈ �Դϴ�")			// �˸� ���� ����
//								.setIcon("stock_ticker_update")			// �˸� ������ ����, �ȵ���̵��� "@drawable/example" �� ����
//								.build())
//						.build())
//				.putData("requestId", Integer.toString(requestId))		// ������ ���̷ε� (����): request �ĺ� ����
//				.setToken(registrationToken)							// ��û�� ����̽��� ���� registration token ����
//				.build();
//		
//		// // Send a message to the device corresponding to the provided registration token.
//		String response = FirebaseMessaging.getInstance().send(message);
//		// Response is a message ID string.
//		System.out.println("PostRestController - Successfully sent message : " + response);
//		
//		return response;
//	}
	
}
