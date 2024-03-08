package com.botech.servicionotificaciones;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
public class Resquest {

    public void sendRequest() throws FirebaseMessagingException {
        // This registration token comes from the client FCM SDKs.
        String registrationToken = "eOHY_rpoSPOxSEhM3FvZKl:APA91bF4gjsZBamtMEKT1Tc8IeGWoroFyC07Mm3SVzjiCi00C_PcuhhQQofh5w75kb3TtKf8YLCE9VWFjMEs1qt_fPlEnyZ4F-gjPde_mOHzrz68pHbW9eskbvnIl4I7EdL3mTfJSNoO";

// See documentation on defining a message payload.
        Message message = Message.builder()
                .putData("score", "850")
                .putData("time", "2:45")
                .setToken(registrationToken)
                .build();

// Send a message to the device corresponding to the provided
// registration token.
        String response = FirebaseMessaging.getInstance().send(message);
// Response is a message ID string.
        System.out.println("Successfully sent message: " + response);
    }
}
