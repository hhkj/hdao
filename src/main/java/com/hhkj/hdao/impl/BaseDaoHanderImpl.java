package com.hhkj.hdao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SqlRunner;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hhkj.dao.exception.DaoException;
import com.hhkj.hdao.BaseDaoHander;

/**
 * 
 * 
 * @Title: BaseDaoHanderImpl.java
 * @Prject: hdao
 * @Package: com.hhkj.hdao.impl
 * @Description: dao的辅助类
 * @author: maxh
 * @date: 2014年5月1日 下午5:01:49
 * @version: V1.0
 */
public class BaseDaoHanderImpl implements BaseDaoHander {
	private SqlSessionFactory sessionFactory;
	private String resource = "SqlMapConfig.xml";
	private final static Logger logger = LoggerFactory
			.getLogger(BaseDaoHanderImpl.class);

	public BaseDaoHanderImpl(String environment) {

		try {
			InputStream in = Resources.getResourceAsStream(resource);
			sessionFactory = new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			logger.info("\n---dao初始化过程失败,失败原因:{}", e.getMessage());
		}
	}

	public Configuration getConfiguration() {
		return sessionFactory.getConfiguration();
	}

	public Connection getConnection() {
		try {
			return getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public DataSource getDataSource() {
		return getConfiguration().getEnvironment().getDataSource();
	}

	public SqlSession getSqlSession() throws DaoException {
		SqlSession sqlSession = null;
		try {
			sqlSession = sessionFactory.openSession(true);
			logger.info("\n---成功得到session:{}", sqlSession);
		} catch (Exception e) {
			throw new DaoException("得到session失败", e);
		}
		return sqlSession;

	}

	public SqlSession getBatchSqlSession() throws DaoException {
		SqlSession sqlSession = null;
		try {
			sqlSession = sessionFactory.openSession(ExecutorType.BATCH, false);
			logger.info("\n---成功得到session;ID:{}", sqlSession);
		} catch (Exception e) {
			throw new DaoException("得到批处理session失败", e);
		}
		return sqlSession;
	}

	public void closeSqlSession(SqlSession session) {

		if (session != null) {
			try {
				session.close();
				logger.info("\n---成功关session:{}", session);
			} catch (Exception e) {
				logger.info("\n---关闭失败session:{}", session);
			}
		} else {
			// Logging.ERROR(BaseDaoHanderImpl.class, "连接已经关闭");
			logger.info("\n---连接已经关闭");
		}
	}

	public String getStatement(String statementId) {

		return statementId;
	}

	public SqlRunner getSqlRunner() {
		return new SqlRunner(getConnection());
	}

}
