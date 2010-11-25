package com.mydomain.messages.action;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import java.util.Map.Entry;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.jboss.seam.annotations.Name;
import org.jruby.RubyException;
import org.jruby.exceptions.RaiseException;
import org.jruby.runtime.builtin.IRubyObject;

@Stateless
@Name("jruby")
public class JRubyBean implements JRuby, JRubyRemote {
	
	@EJB
	private JRubyService jrubyService;
		
	private PrintStream out = System.out;
	
	@Override
	public String getMessageFromRubyClass() throws IOException {
	
		//initRubyEngine();
		
		//printSystemProperties();
		
		RubyProxy rubyProxy = 
			jrubyService.getProxy("HelloWorld", "hello_world", "\\src\\hello_world\\lib");
		
		IRubyObject response = null;
		try {
			long initial = System.currentTimeMillis();
			response = rubyProxy.callMethod("hello");
			System.out.println(System.currentTimeMillis() - initial);
		} catch(RaiseException re) {
			RubyException rr = re.getException();
			if(rr != null) {
				out.println("RubyException: " + rr.inspect());
				rr.printBacktrace(out);
			} else {
				out.println("RaiseException: " + re.toString());
			}
			return null;
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		return response.toString();
	}

	@SuppressWarnings({ "unchecked", "unused" })
	private void printSystemProperties() {
		
		//String dirs = System.getProperty("catalina.ext.dirs");
		
		Properties properties = System.getProperties();
		
		for (Entry entry : properties.entrySet()) {
			System.out.println("key: " + entry.getKey() + " - value: " + entry.getValue());
		}
		
	}
	
}
