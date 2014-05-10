/**
 * 
 */
package com.hhkj.hdao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hhkj.hdao.BaseDao;
import com.hhkj.hdao.BaseDaoHander;
import com.hhkj.hdao.util.Page;

/**
 * 
 * 
 * @Title: BaseDaoImpl.java
 * @Prject: hdao
 * @Package: com.hhkj.hdao.impl
 * @Description: TODO (描述)
 * @author: maxh
 * @date: 2014年5月1日 下午4:57:33
 * @version: V1.0
 */
public class BaseDaoImpl implements BaseDao {
	private final static Logger logger = LoggerFactory
			.getLogger(BaseDaoImpl.class);
	private BaseDaoHander baseDaoHander;

	/**
	 * 设定Dao助手对象
	 * 
	 * @param baseDaoHander
	 *            the baseDaoHander to set
	 */
	public void setBaseDaoHander(BaseDaoHander baseDaoHander) {
		this.baseDaoHander = baseDaoHander;
	}

	/**
	 * @Method: queryOne
	 * @Description: TODO
	 * @param statementId
	 * @param parameter
	 * @return
	 * @see com.hhkj.hdao.BaseDao#queryOne(java.lang.String, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T queryOne(String statementId, Object parameter) {
		SqlSession session = null;
		T t = null;
		try {
			session = baseDaoHander.getSqlSession();
			String statement = baseDaoHander.getStatement(statementId);
			t = (T) session.selectOne(statement, parameter);
		} catch (Exception e) {
			logger.info("查询单个实体失败；失败原因：{}", e.getMessage());

		} finally {
			baseDaoHander.closeSqlSession(session);
		}
		return t;
	}

	/**
	 * @Method: queryList
	 * @Description: TODO
	 * @param statementId
	 * @param parameter
	 * @return
	 * @see com.hhkj.hdao.BaseDao#queryList(java.lang.String, java.lang.Object)
	 */
	@Override
	public <T> List<T> queryList(String statementId, Object parameter) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @Method: queryPage
	 * @Description: TODO
	 * @param totalStatementId
	 * @param statementId
	 * @param page
	 * @return
	 * @see com.hhkj.hdao.BaseDao#queryPage(java.lang.String, java.lang.String,
	 *      com.hhkj.hdao.util.Page)
	 */
	@Override
	public <T> Page<T> queryPage(String totalStatementId, String statementId,
			Page<T> page) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @Method: queryOneBySql
	 * @Description: TODO
	 * @param sql
	 * @param parameter
	 * @return
	 * @see com.hhkj.hdao.BaseDao#queryOneBySql(java.lang.String,
	 *      java.lang.Object[])
	 */
	@Override
	public Map<String, Object> queryOneBySql(String sql, Object... parameter) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @Method: queryListBySql
	 * @Description: TODO
	 * @param sql
	 * @param parameter
	 * @return
	 * @see com.hhkj.hdao.BaseDao#queryListBySql(java.lang.String,
	 *      java.lang.Object[])
	 */
	@Override
	public List<Map<String, Object>> queryListBySql(String sql,
			Object... parameter) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @Method: updateBatch
	 * @Description: TODO
	 * @param statementId
	 * @param parameter
	 * @return
	 * @see com.hhkj.hdao.BaseDao#updateBatch(java.lang.String, java.util.List)
	 */
	@Override
	public <T> int updateBatch(String statementId, List<T> parameter) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @Method: updateOne
	 * @Description: TODO
	 * @param statementId
	 * @param parameter
	 * @return
	 * @see com.hhkj.hdao.BaseDao#updateOne(java.lang.String, java.lang.Object)
	 */
	@Override
	public <T> int updateOne(String statementId, T parameter) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @Method: delete
	 * @Description: TODO
	 * @param statementId
	 * @param parameter
	 * @return
	 * @see com.hhkj.hdao.BaseDao#delete(java.lang.String, java.lang.Object)
	 */
	@Override
	public <T> int delete(String statementId, T parameter) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @Method: deleteBatch
	 * @Description: TODO
	 * @param statementId
	 * @param parameter
	 * @return
	 * @see com.hhkj.hdao.BaseDao#deleteBatch(java.lang.String, java.util.List)
	 */
	@Override
	public <T> int deleteBatch(String statementId, List<T> parameter) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @Method: insertOne
	 * @Description: TODO
	 * @param statementId
	 * @param parameter
	 * @return
	 * @see com.hhkj.hdao.BaseDao#insertOne(java.lang.String, java.lang.Object)
	 */
	@Override
	public <T> int insertOne(String statementId, T parameter) {
		SqlSession session = null;
		try {
			session = baseDaoHander.getSqlSession();
			return session.insert(baseDaoHander.getStatement(statementId),
					parameter);
		} catch (Exception e) {
			if (session != null)
				session.rollback();
			logger.info("更新单个实体失败；失败原因：{}", e.getMessage());
		} finally {
			baseDaoHander.closeSqlSession(session);
		}
		return -1;
	}

	/**
	 * @Method: insertBatch
	 * @Description: TODO
	 * @param statementId
	 * @param parameter
	 * @return
	 * @see com.hhkj.hdao.BaseDao#insertBatch(java.lang.String, java.util.List)
	 */
	@Override
	public <T> int insertBatch(String statementId, List<T> parameter) {
		// TODO Auto-generated method stub
		return 0;
	}

}
