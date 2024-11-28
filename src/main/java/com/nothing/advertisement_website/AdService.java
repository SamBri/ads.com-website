package com.nothing.advertisement_website;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class AdService implements IAdService {

	@Autowired
	AdsRepo adsRepo;

	@Transactional
	@Override
	public List<Ad> getAllAds() {

		List<Ad> list = adsRepo.findByOrderByIdDesc();

		return list;
	}

	
	@Transactional
	@Override
	public Ad getAdByAdId(UUID adId) {


	  Ad tempAd =	adsRepo.findAdByAdId(adId);
		
		
		return tempAd;
	}

}
