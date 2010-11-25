package com.mydomain.messages.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jruby.Ruby;
import org.jruby.RubyClass;
import org.jruby.RubyKernel;
import org.jruby.runtime.Block;
import org.jruby.runtime.builtin.IRubyObject;

import com.mydomain.messages.model.SysConfig;



@Stateless
public class JRubyServiceBean implements JRubyService {
	
	private PrintStream out;
	private List<String> loadPaths;
	private String jrubyHome;

	@PersistenceContext
	private EntityManager em;
	
	@PostConstruct
	public void init() {
		
		String jrubyHome = 
			"D:\\seam-dev\\jboss-4.2.3.GA\\server\\default\\deploy\\SeamJRuby.ear\\script\\ruby"; //getJRubyHome();
		
		// Agrega variables de sistema
		System.setProperty("jruby.home", jrubyHome);
		System.setProperty("jruby.base", jrubyHome);
		System.setProperty("jruby.lib", jrubyHome + "\\lib");
		System.setProperty("jruby.script", "jruby");
		//System.setProperty("jruby.shell", "/bin/sh");

		// Archivo de Log
		try {
			out = new PrintStream(
					new FileOutputStream(jrubyHome + "\\log", true));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		
		// Agrega los load paths
		loadPaths = new ArrayList<String>();
		loadPaths.add(jrubyHome + "\\src");
		loadPaths.add(jrubyHome + "\\jar");
	}
	
	@PreDestroy
	public void destruct() {
		out.close();
	}
	
	public RubyProxy getProxy(String clazz, String require, String loadPath) {
		Ruby engine;
		// Invoca al metodo new de la clase ruby
		IRubyObject rubyObject;
		try {
			engine = Ruby.newInstance(System.in, out, out);
			loadPaths.add(getJRubyHome() + loadPath);
			engine.getLoadService().init(loadPaths);
			RubyKernel.require(engine.getModule("Kernel"), engine.newString(require), Block.NULL_BLOCK);
			RubyClass rubyClass = engine.getClass(clazz);

			rubyObject = rubyClass.callMethod(engine.getCurrentContext(), "new");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return new RubyProxy(rubyObject, engine);
	}
	
	public String getJRubyHome() {
		
		if (this.jrubyHome == null) {
			this.jrubyHome = getJRubyConfig().getConfigValue();
		}
		
		return this.jrubyHome;
	}

	private SysConfig getJRubyConfig() {
		
		SysConfig config = (SysConfig) 
		em.createQuery("from SysConfig s where s.configKey = :key")
			.setParameter("key", "jruby.home")
			.getSingleResult();
		
		return config;
	}

	/**
	 * Devuelve el entity manager injectado. Este metodo
	 * esta pensado para ser llamado desde scripts ruby.
	 */
	public EntityManager getEntityManager() {
		return em;
	}
	
}
