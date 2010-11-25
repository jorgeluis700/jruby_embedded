package com.mydomain.util;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Date;

public class LogPrintStream extends PrintStream {

	public LogPrintStream(OutputStream out) {
		super(out);
	}

	@Override
	public void println(String x) {
		
		if (x != null) {
			Date date = new Date();
			x = date.toString() + ": " + x;
		}
		
		super.println(x);
	}

	@Override
	public void print(String s) {
	
		if (s != null) {
			Date date = new Date();
			s = date.toString() + ": " + s;
		}
	
		super.print(s);
	}

	
	

}
