package com.doe.afs.config;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.doe.afs.interceptor.LogInterceptor;

/**
 * 
* @ClassName: WebConfig
* @Description: 重写WebMvcConfigurationSupport
* @author Coder
* @version V1.0
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
	@Autowired
	private LogInterceptor logInterceptor;
	@Autowired
	private PropertiesConfig propertiesConfig;
	
	
	/**
	 * 	忽略url地址大小写
	 */
	@Override
	protected void configurePathMatch(PathMatchConfigurer configurer) {
		AntPathMatcher matcher = new AntPathMatcher(); 
		matcher.setCaseSensitive(false); 
		configurer.setPathMatcher(matcher); 
	}
	/**
	 * 跨域请求
	 */
	@Override
	protected void addCorsMappings(CorsRegistry registry) {
		registry.addMapping(propertiesConfig.getAllowedMapping())
		.allowedHeaders("*")
        .allowedOrigins(propertiesConfig.getAllowedOrigins())
        .allowedMethods(propertiesConfig.getAllowedMethods().split(","))
        .maxAge(3600)
        .allowCredentials(true);
	}
    
	/**
	 * 	添加统一的拦截器
	 */
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(logInterceptor).addPathPatterns("/**");
		super.addInterceptors(registry);
	}
	
	/**
	 * 处理json格式，值null的转换为""
	 */
	@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty,//字符串null返回空字符串
                SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.PrettyFormat);
        converter.setFastJsonConfig(fastJsonConfig);
        converters.add(converter);
   }

    
}