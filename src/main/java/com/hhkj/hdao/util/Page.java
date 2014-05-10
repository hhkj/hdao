package com.hhkj.hdao.util;

import java.util.HashMap;
import java.util.List;

/**
 * 
 * @ClassName Page
 * @Description 分页类
 * @author maxh
 * @date 2014年5月1日
 * @param <T>
 */
public class Page<T> {
	private int currentPage = 1;// 当前页，默认值为1
	private int limit = 0;// 每页显示个数
	private int totalsize = 0;// 总个数
	private int totalPage = 0;// 总页数
	private int startNum = 0;// 开始条数
	private int endNum = 0;// 结束条数
	private boolean isDataPage = true;// 是不是数据库分页
	private HashMap<String, Object> parameter;// 查询参数
	private HashMap<String, Object> resultMap;// 结果集，包括列表，总条数，总页数
	private List<T> resultList;

	/**
	 * 初始化方法
	 * 
	 * @param isDataPage
	 *            是否是数据库分页
	 * @param limit
	 *            每页显示条数
	 * @param parameter
	 *            查询参数
	 * @param currentPage
	 *            当前页
	 */
	public Page(boolean isDataPage, int limit, int currentPage,
			HashMap<String, Object> parameter) {
		this.isDataPage = isDataPage;
		this.limit = limit;
		this.parameter = parameter;
		this.currentPage = currentPage;
	}

	/**
	 * 初始化方法重载
	 * 
	 * @param isDataPage
	 *            是否是数据库分页
	 * @param limit
	 *            每页显示条数
	 * @param currentPage
	 *            当前页
	 */
	public Page(boolean isDataPage, int limit, int currentPage) {
		this.isDataPage = isDataPage;
		this.limit = limit;
		this.parameter = new HashMap<String, Object>();
		this.currentPage = currentPage;
	}

	/**
	 * 重载初始化方法
	 */
	public Page() {

	}

	public int getStartNum() {
		return startNum;
	}

	public HashMap<String, Object> getParameter() {
		parameter.put("startNum", startNum);
		parameter.put("endNum", endNum);
		return parameter;
	}

	public void setParameter(HashMap<String, Object> parameter) {
		this.parameter = parameter;
	}

	public int getEndNum() {
		return endNum;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotalsize() {
		return totalsize;
	}

	public void setTotalsize(int totalsize) {
		this.totalsize = totalsize;
		this.totalPage = (int) Math.ceil((double) totalsize / limit);
		initIndex();
	}

	/**
	 * 初始化起始条目和结束条目
	 */
	private void initIndex() {
		if (isDataPage) {
			if (totalPage < currentPage) {
				currentPage = totalPage;
			}
			startNum = (currentPage - 1) * limit;
			if (currentPage * limit > totalsize) {

				endNum = totalsize;
			} else {
				endNum = currentPage * limit;
			}
		} else {
			startNum = 0;
			endNum = totalsize;
		}
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setDataPage(boolean isDataPage) {
		this.isDataPage = isDataPage;
	}

	public boolean isDataPage() {
		return isDataPage;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultMap(HashMap<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	/**
	 * @return 结果集，包括列表，总条数，总页数
	 */
	public HashMap<String, Object> getResultMap() {
		resultMap = new HashMap<String, Object>();
		resultMap.put("totalSize", totalsize);
		resultMap.put("resultList", resultList);
		resultMap.put("totalPage", totalPage);
		return resultMap;
	}

	@Override
	public String toString() {
		return "startNum:" + startNum + ";endNum:" + endNum;
	}

}
