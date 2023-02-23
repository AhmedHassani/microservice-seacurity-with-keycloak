package com.iraqsofit.speedoo.service;


import com.iraqsofit.speedoo.models.Educational;
import com.iraqsofit.speedoo.models.NotificationModel;
import com.iraqsofit.speedoo.models.Posts;
import com.iraqsofit.speedoo.models.ProductsModel;
import com.iraqsofit.speedoo.repository.EducationalRepository;
import com.iraqsofit.speedoo.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeAppService {
    @Autowired
    PostsRepository postsRepository;
    @Autowired
    EducationalRepository educationalRepository;

    public List<Posts> getPost(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Posts> pagedResult = postsRepository.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    public List<Educational> getEducational(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Educational> pagedResult = educationalRepository.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    public Posts addPost(Posts posts) {
        return postsRepository.save(posts);
    }

    public Educational addEducational(Educational educational) {
        return educationalRepository.save(educational);
    }







}
