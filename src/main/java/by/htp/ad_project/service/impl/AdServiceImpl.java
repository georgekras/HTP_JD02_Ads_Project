package by.htp.ad_project.service.impl;

import java.util.List;

import by.htp.ad_project.dao.AdDao;
import by.htp.ad_project.domain.Ad;
import by.htp.ad_project.service.AdService;

public class AdServiceImpl implements AdService {

	private AdDao adDao;
	
	public void setAdDao(AdDao adDao) {
		this.adDao = adDao;
	}

	@Override
	public void create(Ad ad) {
		adDao.create(ad);
	}

	@Override
	public Ad read(int id) {
		return adDao.read(id);
	}

	@Override
	public void update(Ad ad) {
		adDao.update(ad);
	}

	@Override
	public void delete(Ad ad) {
		adDao.delete(ad);
	}

	@Override
	public List<Ad> getAllAds() {
		return adDao.readAll();
	}



}
