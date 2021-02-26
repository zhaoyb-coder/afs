package com.doe.afs.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import com.alibaba.druid.util.Utils;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.*;
import java.io.IOException;

/**
* @Description Druid配置
* @author zhaoyubo
* @date 2020-05-13 17:50:02 
*/
@Configuration
@ConditionalOnWebApplication
@AutoConfigureAfter(DruidDataSourceAutoConfigure.class)
@ConditionalOnProperty(name = "spring.datasource.druid.stat-view-servlet.enabled", havingValue = "true", matchIfMissing = true)
public class DruidConfig {

	 /**
     * 方法名: removeDruidAdFilterRegistrationBean
     * 方法描述:  除去页面底部的广告
     * @param properties
     * @return org.springframework.boot.web.servlet.FilterRegistrationBean
     * @throws
     */
    @SuppressWarnings("rawtypes")
	@Bean
    public FilterRegistrationBean removeDruidAdFilterRegistrationBean(DruidStatProperties properties) {
        // 获取web监控页面的参数
        DruidStatProperties.StatViewServlet config = properties.getStatViewServlet();
        // 提取common.js的配置路径
        String pattern = config.getUrlPattern() != null ? config.getUrlPattern() : "/druid/*";
        String commonJsPattern = pattern.replaceAll("\\*", "js/common.js");

        final String filePath = "support/http/resources/js/common.js";

        //创建filter进行过滤
        Filter filter = new Filter() {
            @Override
            public void init(FilterConfig filterConfig) throws ServletException {
            }

            @Override
            public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
                chain.doFilter(request, response);
                // 重置缓冲区，响应头不会被重置
                response.resetBuffer();
                // 获取common.js
                String text = Utils.readFromResource(filePath);
                // 正则替换banner, 除去底部的广告信息
                text = text.replaceAll("<a.*?banner\"></a><br/>", "");
                text = text.replaceAll("powered.*?shrek.wang</a>", "");
                response.getWriter().write(text);
            }

            @Override
            public void destroy() {
            }
        };
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<Filter>();
        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns(commonJsPattern);
        return registrationBean;
    }
    
    @Autowired
	WallFilter wallFilter;
    
    @Bean(name = "wallConfig")
	WallConfig wallFilterConfig() {
		WallConfig wc = new WallConfig();
		//允许sql中存在注释
		wc.setCommentAllow(true);
		return wc;
	}

	@Bean(name = "wallFilter")
	@DependsOn("wallConfig")
	WallFilter wallFilter(WallConfig wallConfig) {
		WallFilter wfilter = new WallFilter();
		wfilter.setConfig(wallConfig);
		return wfilter;
	}
}
