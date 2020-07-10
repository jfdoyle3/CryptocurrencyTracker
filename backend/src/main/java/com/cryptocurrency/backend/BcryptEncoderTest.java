package com.cryptocurrency.backend;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderTest {

	public static void main(String[] args) {

		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		
		for(int idx=1; idx<10; idx++) {
		String encodedString=encoder.encode("password");
		System.out.println(encodedString);
		}
	}

}
