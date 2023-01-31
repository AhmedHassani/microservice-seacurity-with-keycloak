package com.iraqsofit.speedoo.repository;


import com.iraqsofit.speedoo.models.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {

}
