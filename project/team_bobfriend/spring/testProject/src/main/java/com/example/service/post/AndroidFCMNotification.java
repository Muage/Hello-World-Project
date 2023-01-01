package com.example.service.post;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AndroidFCMNotification {

	public static String notificationJson() throws JSONException {
        String sampleData[] = {"d0WFX8SXS7mBp1DDfMz1V4:APA91bGT9DnHOPtGQ-oAM_3JZAI-j8oMc530_3IS8RxuRXBCALhcvgsc-hFYz8hzNy7R74KjdUGc17tB9yTfQpIEMuKV9mVjjMKkQ2EwkwecPOpBp35Pel3cNaGl79Q12rnEALBrhlas"};
//        String sampleData[] = {"dqHOyQC4QBSo7rxUiXtavX:APA91bG2IAWbuC2NYiK3ENeX0b63R7xeb_C12QUO9L7jrFXa4qHX96E-XAwreON0Mlvm5bScB8nwGGcm6tD6gWGFRFGUcpPlOWC1rt37b5NB-Z2CT7jpW46pHyDdNaXg_-IHVG-THKwk"};
        JSONObject body = new JSONObject();
        
        // 알림 보낼 디바이스 토큰 목록
        List<String> tokenlist = new ArrayList<String>();
        for(int i = 0; i < sampleData.length; i++) {
            tokenlist.add(sampleData[i]);
        }

        // 각 디바이스 토큰 값
        JSONArray array = new JSONArray();
        for(int i = 0; i < tokenlist.size(); i++) {
            array.put(tokenlist.get(i));
        }
        body.put("registration_ids", array);

        JSONObject notification = new JSONObject();
        notification.put("title", "hello!");					// 알림 제목
        notification.put("body", "This is notification test");	// 알림 내용
        body.put("notification", notification);

        System.out.println(body.toString());

        return body.toString();
    }
	
}

//@Service
//public class FCMService {
//	
//	@PostConstruct
//	public void initialize() throws IOException {
//		// Admin SDK 구성 스니펫
//		// 비공개키 폴더 위치 공유되지 않는 곳으로 옮겨야함
//		FileInputStream serviceAccount = new FileInputStream("c:/Data/Spring/testProject/src/main/resources/fcmapp-4d7c2-firebase-adminsdk-6ipra-012845f1a2.json");
//		
//		FirebaseOptions options = new FirebaseOptions.Builder()
//		  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//		  .setProjectId("692300612657")
//		  .build();
//		
//		FirebaseApp.initializeApp(options);
//	}
//	
//	// send message to android
//	public String sendMessage(int requestId, String registrationToken) throws FirebaseMessagingException {
//		Message message = Message.builder()
//				.setAndroidConfig(AndroidConfig.builder()
//						.setTtl(3600 * 1000)
//						.setPriority(AndroidConfig.Priority.HIGH)
//						.setRestrictedPackageName("com.icia.friend")
//						.setDirectBootOk(true)
//						.setNotification(AndroidNotification.builder()	// 알림 구성
//								.setTitle("테스트")						// 알림 제목 설정
//								.setBody("FCMService 테스트 입니다")			// 알림 내용 설정
//								.setIcon("stock_ticker_update")			// 알림 아이콘 설정, 안드로이드의 "@drawable/example" 도 가능
//								.build())
//						.build())
//				.putData("requestId", Integer.toString(requestId))		// 데이터 페이로드 (선택): request 식별 정보
//				.setToken(registrationToken)							// 요청자 디바이스에 대한 registration token 설정
//				.build();
//		
//		// // Send a message to the device corresponding to the provided registration token.
//		String response = FirebaseMessaging.getInstance().send(message);
//		// Response is a message ID string.
//		System.out.println("Successfully sent message: " + response);
//		
//		return response;
//	}
//
//}
