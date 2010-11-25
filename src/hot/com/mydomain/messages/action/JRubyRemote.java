package com.mydomain.messages.action;

import java.io.IOException;

import javax.ejb.Remote;


@Remote
public interface JRubyRemote {

	String getMessageFromRubyClass() throws IOException;

}
