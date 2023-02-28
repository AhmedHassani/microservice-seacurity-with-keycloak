package com.iraqsofit.speedoo.service;


import com.iraqsofit.speedoo.models.NotificationModel;
import com.iraqsofit.speedoo.models.ProductsModel;
import com.iraqsofit.speedoo.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {
    @Autowired
    NotificationRepository repository;
    private String appId ="17490aa8-8263-4e19-afc9-8cb7cfd359fb";
    private String message = "Testing";

    public List<NotificationModel> getNotifications(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<NotificationModel> pagedResult = repository.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    public NotificationModel pushNotification(NotificationModel notificationModel) {
        return repository.save(notificationModel);
    }

    public ResponseEntity sentNotification(String playerId, boolean sendToAll){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("accept", "application/json");
        headers.add("Authorization", "Basic ODU3MDUzMjQtYTcyMi00NzllLTg1MjktNTcwNjlmYzlhODU2");
        headers.add("content-type", "application/json");
        RestTemplate restTemplate = new RestTemplate();
        String json = "{"
                + "\"app_id\": \"" + appId + "\","
                + "\"contents\": {\"en\": \"" + message + "\"}";

        if (sendToAll) {
            json += ",\"included_segments\": [\"All\"]}";
        } else {
            json += ",\"include_player_ids\": [\"" + playerId + "\"]}";
        }

        HttpEntity<String> request = new HttpEntity<>(json,headers);
        String response = restTemplate.postForObject("https://onesignal.com/api/v1/notifications", request, String.class);
        return ResponseEntity.ok(response);
    }




}
