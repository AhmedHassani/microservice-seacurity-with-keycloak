package com.iraqsofit.speedoo.repository;

import com.iraqsofit.speedoo.models.Posts;
import com.iraqsofit.speedoo.models.ProductsModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
