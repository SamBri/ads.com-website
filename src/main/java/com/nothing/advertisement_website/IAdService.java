package com.nothing.advertisement_website;

import java.util.List;
import java.util.UUID;

public interface IAdService {
	
	List<Ad> getAllAds();

	Ad getAdByAdId(UUID adId);

}
