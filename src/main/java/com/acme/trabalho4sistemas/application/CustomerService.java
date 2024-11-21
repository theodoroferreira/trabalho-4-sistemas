package com.acme.trabalho4sistemas.application;

import com.acme.trabalho4sistemas.domain.CustomerDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.cloud.StorageClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final String FILE_NAME = "clientes.json";

    public String saveCustomer(CustomerDto request) throws JsonProcessingException {
        Bucket bucket = StorageClient.getInstance().bucket();

        String jsonData = objectMapper.writeValueAsString(request);

        Blob blob = bucket.create(FILE_NAME, jsonData.getBytes());

        return blob.getMediaLink();
    }
}
