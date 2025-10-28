package com.ty.read;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = new AnnotationConfigApplicationContext(MyConfig.class);

		User user = app.getBean(User.class);
		user.display();

		DBConnection con = app.getBean(DBConnection.class);
		con.createConn();
	}
}
