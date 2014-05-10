package com.hhkj.hdao.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hhkj.hdao.BaseDao;
import com.hhkj.hdao.BaseDaoHander;

/**
 * 
 * 
 * @Title: DaoFactory.java
 * @Prject: hdao
 * @Package: com.hhkj.hdao.impl
 * @Description: dao工厂
 * @author: maxh
 * @date: 2014年5月1日 下午5:03:08
 * @version: V1.0
 */
public class DaoFactory {
	private final static Logger logger = LoggerFactory
			.getLogger(DaoFactory.class);
	private static Map<String, BaseDaoHander> daoHanderMap = new ConcurrentHashMap<String, BaseDaoHander>();
	private static Map<String, BaseDao> daoMap = new ConcurrentHashMap<String, BaseDao>();

	/**
	 * 得到Dao
	 * 
	 * @return the dao
	 */
	public static BaseDao getDao(String environmentid) {
		BaseDaoImpl dao = (BaseDaoImpl) daoMap.get(environmentid);
		if (dao == null) {
			BaseDaoHander bdh = getBasedaohander(environmentid);
			dao = new BaseDaoImpl();
			dao.setBaseDaoHander(bdh);
			daoMap.put(environmentid, dao);
			logger.info("新建数据源：{}",environmentid);

		}
		return dao;
	}

	/**
	 * 得到Dao助手类
	 * 
	 * @return the basedaohander
	 */
	public static BaseDaoHander getBasedaohander(String environmentid) {
		BaseDaoHander bdh = daoHanderMap.get(environmentid);
		if (bdh == null) {
			bdh = new BaseDaoHanderImpl(environmentid);
			daoHanderMap.put(environmentid, bdh);
		}
		return bdh;
	}
}
