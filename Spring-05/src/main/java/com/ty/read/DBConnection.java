package com.ty.read;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DBConnection {

	@Value(value = "${db.url}")
	private String url;
	@Value(value = "${db.username}")
	private String username;
	@Value(value = "${db.password}")
	private String password;

	public void createConn() {
		System.out.println("connection created to below db");
		System.out.println
		(url + "?user=" + username + "&password=" + password);
	}
}
