package com.mydomain.messages.action;

import org.jruby.Ruby;
import org.jruby.runtime.builtin.IRubyObject;

/**
 * Representa un objecto ruby con su contexto.
 * @author Jorge
 *
 */
public class RubyProxy {
	
	private IRubyObject object;
	private Ruby engine;

	public RubyProxy(IRubyObject rubyObject, Ruby engine) {
		this.object = rubyObject;
		this.engine = engine;
	}

	public IRubyObject callMethod(String method) {
		return object.callMethod(engine.getCurrentContext(), method);
	}

}
