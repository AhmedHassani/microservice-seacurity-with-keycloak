package com.iraqsofit.speedoo.barcode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BarCodeRepository extends JpaRepository<BarCode, Long> {

}
