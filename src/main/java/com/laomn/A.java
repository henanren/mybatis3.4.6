package com.laomn;

import org.springframework.stereotype.Component;

@Component
public class A implements Caller {

	@Override
	public String getTenant() {
		System.out.println("getTenant");
		return null;
	}

}
