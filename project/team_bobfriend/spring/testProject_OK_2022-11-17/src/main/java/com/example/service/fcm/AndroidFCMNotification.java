package com.example.service.fcm;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AndroidFCMNotification {

	public static String notificationJson() throws JSONException {
        String sampleData[] = {"dgWnzUaVSDG3M02AW9rXPS:APA91bH1R9oh_J8ZbkB5xER-YOWCnjVyBFBSo6Nf_WNkMHm0Dr9gLWY7YcyD6Ji-KkU9EbUXrAv4N8Ch_lpJSo2WS3NCyCMjoYGBiXVuXyw9tGdvJc5Crg-PNFmy2kbtfvLkFZc_EjCX"};
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
        notification.put("title", "hello!");						// 알림 제목
        notification.put("body", "This is notification test");		// 알림 내용
        body.put("notification", notification);

        System.out.println(body.toString());

        return body.toString();
    }
	
}
