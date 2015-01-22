package com.mylab;

import java.util.UUID;

public class GenerateUUID {
	public static String getUUID() {
		String s = UUID.randomUUID().toString();
		return s.replace("-","");
	}
}
