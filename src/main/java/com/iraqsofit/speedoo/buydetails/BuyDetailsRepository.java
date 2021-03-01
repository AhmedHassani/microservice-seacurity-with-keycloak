package com.iraqsofit.speedoo.buydetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BuyDetailsRepository extends JpaRepository<BuyDetails, Long> {

}
