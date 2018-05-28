package by.htp.ad_project.dao;

import java.util.List;

import by.htp.ad_project.domain.Ad;

public interface AdDao extends BaseDao<Ad> {

	List<Ad> readUserAds(int user_ID);
}
