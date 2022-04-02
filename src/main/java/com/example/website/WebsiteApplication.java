package com.example.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebsiteApplication {
	private static Long siteUserID;

	public static Long getSiteUserID() {
		return siteUserID;
	}

	public static void setSiteUserID(Long siteUserID) {
		WebsiteApplication.siteUserID = siteUserID;
	}

	public static void main(String[] args) {
		SpringApplication.run(WebsiteApplication.class, args);
	}

}
