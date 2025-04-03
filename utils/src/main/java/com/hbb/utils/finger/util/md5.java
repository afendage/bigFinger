package com.hbb.utils.finger.util;

import org.junit.Test;
import java.util.Base64;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class md5 {
	
	@Test
	public void test() {
		String md5Str = this.md5_encode("123456");
		System.out.println(md5Str);

	}

	public String md5_encode(String str) {
		String s = str;
		if (s == null) {
			return "";
		} else {
			String value = null;
			MessageDigest md5 = null;
			try {
				md5 = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			Base64.Encoder encoder = Base64.getEncoder();
			try {
				byte[] result = encoder.encode(md5.digest(s.getBytes("UTF-8")));
				value = encoder.encodeToString(result);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return value;
		}
	}
}
