package com.nothing.advertisement_website;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdsRepo extends JpaRepository<Ad, Long> {

	Ad findAdByAdId(UUID adId);
	
	List<Ad> findByOrderByIdDesc();

}
