package com.iraqsofit.speedoo.salesdetaits;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SalesDetailsRepository extends JpaRepository<SalesDetails, Long> {

}
