package com.mydomain.messages.action;

import javax.ejb.Local;

@Local
public interface Authenticator {

    boolean authenticate();

}
