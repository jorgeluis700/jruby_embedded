package com.mydomain.messages.action;

import javax.ejb.Local;
import javax.persistence.EntityManager;

@Local
public interface JRubyService {
	
	public RubyProxy getProxy(String clazz, String require, String loadPath);
	
	public String getJRubyHome();

	public EntityManager getEntityManager();
	
}
