package com.akash;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class varification {
	String mobile;
	List<String> l= new ArrayList<String>();
public Collection<String> validate(String mobile)
{
	this.mobile=mobile;
	if(mobile.length()>10) {
		l.add("mobile");
	
	}
	
	
	return l;
	
	
}

}
