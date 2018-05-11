package by.htp.ad_project.service;

import java.util.List;

import by.htp.ad_project.domain.Ad;

public interface AdService {
	
	void create(Ad ad);
	
	Ad read(int id);
	
	void update(Ad ad);
	
	void delete(Ad ad);
	
	List<Ad> getAllAds();

}
