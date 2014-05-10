package com.hhkj.hdao;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.jdbc.SqlRunner;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;

import com.hhkj.dao.exception.DaoException;

/**
 * 
 * 
 * @Title: BaseDaoHander.java
 * @Prject: hdao
 * @Package: com.hhkj.hdao
 * @Description: Dao助手类可以从中得到mybatis中数据连接的基本属性
 * @author: maxh
 * @date: 2014年5月1日 下午4:59:38
 * @version: V1.0
 */
public interface BaseDaoHander {
	/**
	 * 得到普通session；自动commit
	 * 
	 * @return
	 * @throws DaoException
	 */
	SqlSession getSqlSession() throws DaoException;

	/**
	 * 得到批处理session；需要手动commit
	 * 
	 * @return
	 * @throws DaoException
	 */
	SqlSession getBatchSqlSession() throws DaoException;

	/**
	 * 得到mybatis环境上下文
	 * 
	 * @return
	 */
	Configuration getConfiguration();

	/**
	 * 得到数据源
	 * 
	 * @return
	 */
	DataSource getDataSource();

	/**
	 * 从连接池得到连接对象
	 * 
	 * @return
	 */
	Connection getConnection();

	/**
	 * 当session不为空时关闭session
	 * 
	 * @param session
	 */
	void closeSqlSession(SqlSession session);

	/**
	 * 得到mybatis指定id的sql目录；空间名+sqlId
	 * 
	 * @param statementId
	 * @return
	 */
	String getStatement(String statementId);

	SqlRunner getSqlRunner();
}
