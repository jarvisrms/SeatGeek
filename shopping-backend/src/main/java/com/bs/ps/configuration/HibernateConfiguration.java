package com.bs.ps.configuration;



import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.bs.ps.dto"})
@EnableTransactionManagement
public class HibernateConfiguration {

	private String DATABSE_URL="jdbc:h2:tcp://localhost/~/shopping"; 
	private String DATABSE_USERNAME="sa"; 
	private String DATABSE_PASSWORD=""; 
	private String DATABSE_DIALECT="org.hibernate.dialect.H2Dialect"; 
	private String DATABSE_DRIVER="org.h2.Driver";
	
	
	// bean for datasource
	
	@Bean("datasource")
	public DataSource getDataSource()
	{
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl(DATABSE_URL);
		ds.setUsername(DATABSE_USERNAME);
		ds.setPassword(DATABSE_PASSWORD);
		ds.setDriverClassName(DATABSE_DRIVER);
		return ds;
	}
	
	@Bean()
	public SessionFactory getSessionFactory(DataSource ds)
	{
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(ds);
		builder.addProperties(getproperties());
		builder.scanPackages("com.bs.ps.dto");
		return builder.buildSessionFactory();
	}

	private Properties getproperties() {
		// TODO Auto-generated method stub
		Properties pr =new Properties();
		pr.put("hibernate.dialect", DATABSE_DIALECT);
		pr.put("hibernate.show_sql", true);
		pr.put("hibernate.format_sql", true);
				
		return pr;
	}
	
	@Bean
	public HibernateTransactionManager getHTM(SessionFactory fac)
	{
		HibernateTransactionManager htm = new HibernateTransactionManager(fac);
		return htm;
	}
	
}
