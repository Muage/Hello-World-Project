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
        
        // �˸� ���� ����̽� ��ū ���
        List<String> tokenlist = new ArrayList<String>();
        for(int i = 0; i < sampleData.length; i++) {
            tokenlist.add(sampleData[i]);
        }

        // �� ����̽� ��ū ��
        JSONArray array = new JSONArray();
        for(int i = 0; i < tokenlist.size(); i++) {
            array.put(tokenlist.get(i));
        }
        body.put("registration_ids", array);

        JSONObject notification = new JSONObject();
        notification.put("title", "hello!");					// �˸� ����
        notification.put("body", "This is notification test");	// �˸� ����
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
//		// Admin SDK ���� ������
//		// �����Ű ���� ��ġ �������� �ʴ� ������ �Űܾ���
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
//		System.out.println("Successfully sent message: " + response);
//		
//		return response;
//	}
//
//}
