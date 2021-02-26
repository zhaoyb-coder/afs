package com.doe.afs.config;

import javax.sql.DataSource;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

import java.util.Properties;

/**
* @Description afs库数据源配置类
* @author zhaoyubo
* @date 2020-07-28 10:21:42 
*/
@Configuration
@ConfigurationProperties(prefix = "mybatis.configuration")
@MapperScan(basePackages = {"com.doe.afs.mapper"},
			sqlSessionFactoryRef = "afsSqlSessionFactory")
public class AfsDataSourcesConfig {

	private static final String MAPPER_LOCAL = "classpath:mybatis/**/*.xml";

    @ConfigurationProperties("spring.datasource.druid")
    @Primary
    @Bean(name = "afsDataSource")
    public DruidDataSource druidDataSource() {
        return new DruidDataSource();
    }

    @Bean(name = "afsTransactionManager")
    @Primary  //代表主数据源
    public DataSourceTransactionManager wimTransactionManager() {
        return new DataSourceTransactionManager(druidDataSource());
    }

    @Bean(name = "afsSqlSessionFactory")
    @Primary
    public SqlSessionFactory wimSqlSessionFactory(@Qualifier("afsDataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        //分页插件
        Interceptor interceptor = new PageInterceptor();
        Properties properties = new Properties();
        //数据库
        properties.setProperty("helperDialect", "mysql");
        //是否分页合理化
        properties.setProperty("reasonable", "true");
        interceptor.setProperties(properties);

        sessionFactoryBean.setPlugins(new Interceptor[] {interceptor});
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setVfs(SpringBootVFS.class);
        sessionFactoryBean.setTypeAliasesPackage("com.doe.afs.vo");
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCAL));
        return sessionFactoryBean.getObject();
    }
}
