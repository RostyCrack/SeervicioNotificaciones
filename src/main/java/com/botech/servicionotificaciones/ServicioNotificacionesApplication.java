package com.botech.servicionotificaciones;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

import java.io.IOException;

@SpringBootApplication
public class ServicioNotificacionesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicioNotificacionesApplication.class, args);
        FirebaseApp.initializeApp();
        FirebaseOptions options = null;
        try {
            options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(new FileInputStream("src/main/resources/prueba-notificaciones-pu-d8198-firebase-adminsdk-9ebz1-4e311d8ceb.json")))
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        FirebaseApp.initializeApp(options);
        Resquest resquest = new Resquest();
        try {
            resquest.sendRequest();
        } catch (FirebaseMessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
