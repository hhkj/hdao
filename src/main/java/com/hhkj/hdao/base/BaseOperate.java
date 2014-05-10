package com.hhkj.hdao.base;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.hhkj.hdao.BaseDao;
import com.hhkj.hdao.impl.DaoFactory;
import com.hhkj.hdao.util.Page;
import com.hhkj.hdao.util.StringUtile;
/**
 * 包含增删改查的基类
 *
 */
public abstract class BaseOperate{
	private String namespace;
    protected Map<String,BaseDao> daoMap=new ConcurrentHashMap<String, BaseDao>();//数据库操作接口,dao
    private BaseDao dao;
    /**
     * 初始化环境变量和命名空间
     */
    public BaseOperate(Object nameSpace,String... environmentId)
    {
    	if(nameSpace instanceof String)
    	{
    		setEnvironment((String)nameSpace, environmentId);
    	}
    	else if(nameSpace instanceof Class<?>)
    	{
    		setEnvironment((Class<?>)nameSpace, environmentId);
    	}
    }
    /**
     * 根据ID得到实体
     * @param statementId
     * @param id
     * @return
     */
	protected <T> T queryOneById(String statementId,String id) {
		return queryOne(statementId,id);
	}
    /**
     * 根据ID得到实体
     * @param statementId
     * @param id
	 * @param evid 数据源id
     * @return
     */
	protected <T> T queryOneById(String statementId,String id,String evid) {
		return queryOne(statementId,id,evid);
	}
	/**
	 * 根据指定条件得到实体
	 * @param statementId
	 * @param parameter
	 * @return
	 */
	protected <T> T queryOne(String statementId,Object parameter) {
		return dao.queryOne(namespace+statementId, parameter);
	}
	
	/**
	 * 根据指定条件得到实体
	 * @param statementId 命名空间
	 * @param parameter 参数列表
	 * @param evid 数据源id
	 * @return
	 */
	protected <T> T queryOne(String statementId,Object parameter,String evid) {
		return daoMap.get(evid).queryOne(namespace+statementId, parameter);
	}
	/**
	 * 查询实体列表
	 * @param statementId
	 * @return
	 */
	protected <T> List<T> queryList(String statementId) {
		return queryList(statementId,null);
	}
	
	/**
	 * 查询实体列表
	 * @param statementId
	 * @return
	 */
	protected <T> List<T> queryListForJdbc(String statementId,String evid) {
		return queryListForJdbc(statementId,null,evid);
	}
	/**
	 * 根据指定条件得到实体列表
	 * @param statementId
	 * @param parameter
	 * @return
	 */
	protected <T> List<T> queryList(String statementId,Object parameter)
	{
		return dao.queryList(namespace+statementId, parameter);
	}
	/**
	 * 根据指定条件得到实体列表
	 * @param statementId 命名空间
	 * @param parameter 参数列表
	 * @param evid 数据源id
	 * @return
	 */
	protected <T> List<T> queryListForJdbc(String statementId,Object parameter,String evid)
	{
		return daoMap.get(evid).queryList(namespace+statementId, parameter);
	}
	
    /**
     * 根据page参数等到分页结果
     * @param totalStatementId 总条数sql-id
     * @param statementId 分页sql-id
     * @param page 分页对象
     * @return
     */
	protected <T> Map<String,Object> queryListByPage(String totalStatementId,String statementId,Page<T> page) {
		return dao.queryPage(namespace+totalStatementId, namespace+statementId, page).getResultMap();
	}
	
    /**
     * 根据page参数等到分页结果
     * @param totalStatementId 总条数sql-id
     * @param statementId 分页sql-id
     * @param page 分页对象
     * @param evid 数据源id
     * @return
     */
	protected <T> Map<String,Object> queryListByPage(String totalStatementId,String statementId,Page<T> page,String evid) {
		return daoMap.get(evid).queryPage(namespace+totalStatementId, namespace+statementId, page).getResultMap();
	}
	/**
	 * 插入新的数据
	 * @param statementId
	 * @param parameter
	 * @return
	 */
	protected <T> int insert(String statementId,T parameter)
	{
		return dao.insertOne(namespace+statementId, parameter);
	}
	/**
	 * 插入新的数据
	 * @param statementId
	 * @param parameter
	 * @param evid
	 * @return
	 */
	protected <T> int insert(String statementId,T parameter,String evid)
	{
		return daoMap.get(evid).insertOne(namespace+statementId, parameter);
	}
	/**
	 * 批量插入数据
	 * @param statementId
	 * @param parameter
	 * @return
	 */
	protected <T> int insertBatch(String statementId,List<T> parameter)
	{
		return dao.insertBatch(namespace+statementId, parameter);
	}
	
	/**
	 * 批量插入数据
	 * @param statementId
	 * @param parameter
	 * @return
	 */
	protected <T> int insertBatch(String statementId,List<T> parameter,String evid)
	{
		return daoMap.get(evid).insertBatch(namespace+statementId, parameter);
	}
	/**
	 * 删除数据
	 * @param statementId
	 * @return
	 */
	protected int delete(String statementId)
	{
		return delete(statementId,null);
	}
	/**
	 * 删除数据
	 * @param statementId
	 * @param parameter
	 * @return
	 */
    protected int delete(String statementId,Object parameter)
    {
    	return dao.delete(namespace+statementId, parameter);
    }
    /**
     * 依据指定dao删除实体
     * @param statementId
     * @param evid
     * @return
     */
	protected int deleteOther(String statementId,String evid)
	{
		return deleteOther(statementId,null,evid);
	}
	/**
	 * 依据指定dao删除实体
	 * @param statementId
	 * @param parameter
	 * @param evid
	 * @return
	 */
    protected int deleteOther(String statementId,Object parameter,String evid)
    {
    	return daoMap.get(evid).delete(namespace+statementId, parameter);
    }
    /**
     * 批量删除实体
     * @param statementId
     * @param evid
     * @return
     */
	protected <T> int deleteBatch(String statementId,List<T> parameter)
	{
		return dao.deleteBatch(namespace+statementId,parameter);
	}
	/**
	 * 依据指定dao批量删除实体
	 * @param statementId
	 * @param parameter
	 * @param evid
	 * @return
	 */
    protected <T> int deleteBatch(String statementId,List<T> parameter,String evid)
    {
    	return daoMap.get(evid).deleteBatch(namespace+statementId, parameter);
    }
    
	/**
	 * 更新数据
	 * @param statementId
	 * @param parameter
	 * @return
	 */
	protected <T> int update(String statementId,T parameter)
	{
		return dao.updateOne(namespace+statementId, parameter);
	}
	/**
	 * 更新数据
	 * @param statementId
	 * @param parameter
	 * @param evid
	 * @return
	 */
	protected <T> int update(String statementId,T parameter,String evid)
	{
		return daoMap.get(evid).updateOne(namespace+statementId, parameter);
	}
	/**
	 * 批量更新数据
	 * @param statementId
	 * @param parameter
	 * @return
	 */
	protected <T> int updateBatch(String statementId,List<T> parameter)
	{
		return dao.updateBatch(namespace+statementId, parameter);
	}
	
	/**
	 * 批量更新数据
	 * @param statementId
	 * @param parameter
	 * @return
	 */
	protected <T> int updateBatch(String statementId,List<T> parameter,String evid)
	{
		return daoMap.get(evid).updateBatch(namespace+statementId, parameter);
	}
    /**
     * 设定mybats参数，包括：命名空间和数据库连接环境Id
     * @return
     */
   private void setEnvironment(String nameSpace,String... environmentId)
    {
    	namespace=nameSpace+".";
    	String evid=environmentId.length<1?"jdbc":environmentId[0];
     	if(environmentId.length<1)
    	{
    		daoMap.put(evid,DaoFactory.getDao(evid));
    	}
     	else
    	{
           for (String eid : environmentId) {
       	    daoMap.put(eid, DaoFactory.getDao(eid));
           }
    	}
     	dao=daoMap.get(evid);
    }
    /**
     * 设定mybatis参数，包括：命名空间和数据库连接环境Id
     */
    private void setEnvironment(Class<?> cl,String... environmentId)
    {
    	namespace=StringUtile.lowerInitial(cl.getSimpleName());
    	setEnvironment(namespace, environmentId);
    }
}
