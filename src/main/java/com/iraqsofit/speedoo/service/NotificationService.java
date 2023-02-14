package com.iraqsofit.speedoo.service;


import com.iraqsofit.speedoo.models.NotificationModel;
import com.iraqsofit.speedoo.models.ProductsModel;
import com.iraqsofit.speedoo.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {
    @Autowired
    NotificationRepository repository;


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




}
