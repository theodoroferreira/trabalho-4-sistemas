package com.acme.trabalho4sistemas.framework.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {

    private static final String URL = "https://firebasestorage.googleapis.com/v0/b/purplex-gestor-de-loja.appspot.com/o/clientes.json?alt=media&token=ffe1e36c-4275-4e1d-bdbe-d48beb8c02b3";

    @PostConstruct
    public void initializeFirebase() throws IOException {
        FileInputStream serviceAccount = new FileInputStream(URL);

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setStorageBucket("purplex-gestor-de-loja.appspot.com")
                .build();

        FirebaseApp.initializeApp(options);
    }
}
