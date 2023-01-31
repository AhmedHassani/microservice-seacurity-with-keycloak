package com.iraqsofit.speedoo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserImp,Long> {
    UserImp findByUsername(String username);

    boolean existsByUsername(String username);
}
