package com.iraqsofit.speedoo.repository;

import com.iraqsofit.speedoo.models.AddressInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository  extends JpaRepository<AddressInfo, Long> {
    List<AddressInfo> findAllByUsername(String userId);
}
