package com.victorolesk.workshopmongo.resource.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URI {
	
	public static String decodePatter(String text) {
		try {
			return URLDecoder.decode(text, "UFT-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}

}
