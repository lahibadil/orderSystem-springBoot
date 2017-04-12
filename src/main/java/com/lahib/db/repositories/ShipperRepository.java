package com.lahib.db.repositories;

import com.lahib.db.entities.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Adil on 4/12/2017.
 */
@Repository
public interface ShipperRepository extends JpaRepository<Shipper, Long> {
}
