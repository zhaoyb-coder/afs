package com.doe.afs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: PropertiesConfig
 * @Description: 配置文件
 * @author Coder
 * @version V1.0
 */
@Component
public class PropertiesConfig {
	// cros
	@Value("${cors.allowed.origins:*}")
	private String allowedOrigins;
	@Value("${cors.allowed.mapping:/**}")
	private String allowedMapping;
	@Value("${cors.allowed.methods:HEAD,GET,POST,PUT,DELETE,PATCH}")
	private String allowedMethods;
	 
	public String getAllowedOrigins() {
		return allowedOrigins;
	}

	public void setAllowedOrigins(String allowedOrigins) {
		this.allowedOrigins = allowedOrigins;
	}

	public String getAllowedMethods() {
		return allowedMethods;
	}

	public void setAllowedMethods(String allowedMethods) {
		this.allowedMethods = allowedMethods;
	}

	public String getAllowedMapping() {
		return allowedMapping;
	}

	public void setAllowedMapping(String allowedMapping) {
		this.allowedMapping = allowedMapping;
	}
}