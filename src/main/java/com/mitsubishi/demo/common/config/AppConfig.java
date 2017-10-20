package com.mitsubishi.demo.common.config;

import java.io.File;

import javax.servlet.Filter;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.mitsubishi.demo.common.mapper.InformationTableMapper;
import com.mitsubishi.demo.common.mapper.PersonCareerDataMapper;
import com.mitsubishi.demo.common.mapper.PersonJobHistoryTableMapper;
import com.mitsubishi.demo.common.mapper.PersonTableMapper;

@Configuration
public class AppConfig {

	@Autowired
	DataSourceProperties dataSourceProperties;
	DataSource dataSource;

	// @Bean
	// DataSource realDataSource() {
	// DataSourceBuilder factory =
	// DataSourceBuilder.create(this.dataSourceProperties.getClassLoader())
	// .url(this.dataSourceProperties.getUrl()).username(this.dataSourceProperties.getUsername())
	// .password(this.dataSourceProperties.getPassword());
	// this.dataSource = factory.build();
	// // return this.dataSource;
	// return new Log4jdbcProxyDataSource(this.dataSource);
	// }

	@Bean(destroyMethod = "close")
	@ConfigurationProperties("spring.datasource.druid")
	public DataSource realDataSource() {
		return DruidDataSourceBuilder.create().build();
	}

	@Bean
	public SqlSessionFactory getSqlSessionFactory() {
		Resource[] resources = new Resource[] { getMapperXMLPathResource(PersonTableMapper.class),
				getMapperXMLPathResource(InformationTableMapper.class),
				getMapperXMLPathResource(PersonCareerDataMapper.class),
				getMapperXMLPathResource(PersonJobHistoryTableMapper.class) };
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(realDataSource());
		factoryBean.setMapperLocations(resources);

		SqlSessionFactory sqlSessionFactory = null;
		try {
			sqlSessionFactory = factoryBean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		org.apache.ibatis.session.Configuration configuration = sqlSessionFactory.getConfiguration();
		configuration.setMapUnderscoreToCamelCase(true);

		return sqlSessionFactory;
	}

	public static Resource getMapperXMLPathResource(Class<?> clazz) {
		return new ClassPathResource(clazz.getName().replace(".", File.separator).concat(".xml"));
	}

	@Bean
	public PersonTableMapper getPersonTableMapper() {
		SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(getSqlSessionFactory());
		return sessionTemplate.getMapper(PersonTableMapper.class);
	}

	@Bean
	public InformationTableMapper getInformationTableMapper() {
		SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(getSqlSessionFactory());
		return sessionTemplate.getMapper(InformationTableMapper.class);
	}

	@Bean
	public PersonCareerDataMapper getPersonCareerDataMapper() {
		SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(getSqlSessionFactory());
		return sessionTemplate.getMapper(PersonCareerDataMapper.class);
	}

	@Bean
	public PersonJobHistoryTableMapper getPersonJobHistoryTableMapper() {
		SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(getSqlSessionFactory());
		return sessionTemplate.getMapper(PersonJobHistoryTableMapper.class);
	}

	@Order(Ordered.HIGHEST_PRECEDENCE)
	@Bean
	Filter characterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return filter;
	}
}
