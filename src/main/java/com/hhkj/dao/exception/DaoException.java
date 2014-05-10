package com.hhkj.dao.exception;
/**
 * 
 *
 * @Title: DaoException.java
 * @Prject: hdao
 * @Package: com.hhkj.dao.exception
 * @Description: TODO Dao异常
 * @author: maxh  
 * @date: 2014年5月1日 下午4:59:23
 * @version: V1.0
 */
public class DaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1585919016465044364L;
	public DaoException() {
		super();
	}
    
	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}
	
}
