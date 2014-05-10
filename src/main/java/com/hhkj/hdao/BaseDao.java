/**
 * 
 */
package com.hhkj.hdao;

import java.util.List;
import java.util.Map;

import com.hhkj.hdao.util.Page;

/**
 * 
 * 
 * @ClassName BaseDao
 * @Description 
 *              实体Dao的myBatis默认命名空间为：BaseDaoServlet中myBatis_nameSpace+实体类名的小写，如：com
 *              .hdsx.xxxx .book
 *              当不指定statementId�?采用默认命名空间;若指定statementId时，采用statementId指定的Sql唯一标识执行
 * @author maxh
 * @date 2014年5月1日
 */
public interface BaseDao {
	/**
	 * 查询单个实体
	 * 
	 * @param <T>
	 * @param statementId
	 * @param parameter
	 * @return
	 */
	<T> T queryOne(String statementId, Object parameter);

	/**
	 * 查询实体列表
	 * 
	 * @param <T>
	 * @param statementId
	 * @param parameter
	 * @return
	 */
	<T> List<T> queryList(String statementId, Object parameter);

	/**
	 * 分页查询
	 * 
	 * @param <T>
	 * @param totalStatementId
	 * @param statementId
	 * @param page
	 * @return
	 */
	<T> Page<T> queryPage(String totalStatementId, String statementId,
			Page<T> page);

	/**
	 * 
	 * @param <T>
	 * @param sql
	 * @param parameter
	 * @return
	 */
	Map<String, Object> queryOneBySql(String sql, Object... parameter);

	/**
	 * 
	 * @param <T>
	 * @param sqlParameter
	 * @return
	 */
	List<Map<String, Object>> queryListBySql(String sql, Object... parameter);

	/**
	 * 批量更新数据
	 * 
	 * @param statementId
	 * @param parameter
	 * @return
	 */
	<T> int updateBatch(String statementId, List<T> parameter);

	/**
	 * 更新一个实体
	 * 
	 * @param statementId
	 * @param parameter
	 * @return
	 */
	<T> int updateOne(String statementId, T parameter);

	/**
	 * 删除一个实体
	 * 
	 * @param statementId
	 * @param parameter
	 * @return
	 */
	<T> int delete(String statementId, T parameter);

	/**
	 * 批量删除实体
	 * 
	 * @param statementId
	 * @param parameter
	 * @return
	 */
	<T> int deleteBatch(String statementId, List<T> parameter);

	/**
	 * 插入一个实体
	 * 
	 * @param statementId
	 * @param parameter
	 * @return
	 */
	<T> int insertOne(String statementId, T parameter);

	/**
	 * 批量插入实体
	 * 
	 * @param statementId
	 * @param parameter
	 * @return
	 */
	<T> int insertBatch(String statementId, List<T> parameter);
}
