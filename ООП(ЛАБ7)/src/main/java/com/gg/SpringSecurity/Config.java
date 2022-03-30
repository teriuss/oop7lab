package com.gg.SpringSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


import javax.sql.DataSource;
import java.beans.PropertyVetoException;

public class Config {
    @Configuration
    @EnableWebMvc
    @EnableTransactionManagement
    @ComponentScan("com.gg")
    public class MyConfig {
        @Bean
        public ViewResolver viewResolver(){
            InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
            internalResourceViewResolver.setPrefix("/WEB-INF/view/");
            internalResourceViewResolver.setSuffix(".jsp");
            return internalResourceViewResolver;
        }

        @Bean
        public DataSource dataSource() throws PropertyVetoException {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl( "jdbc:mysql://localhost:3307/Tourism?useSSL=false&serverTimezone=UTC");
            dataSource.setUser("root");
            dataSource.setPassword("root");

            return dataSource;
        }

        @Bean
        public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
            JdbcTemplate template = new JdbcTemplate();
            template.setDataSource(dataSource());
            return template;
        }

        @Bean
        public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException {
            LocalSessionFactoryBean bean = new LocalSessionFactoryBean();

            Properties hibernateProperties = new Properties();
            hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
            hibernateProperties.put("hibernate.show_sql", "true");
            hibernateProperties.put("hibernate.hbm2ddl.auto", "update");

            bean.setHibernateProperties(hibernateProperties);
            bean.setDataSource(dataSource());
            bean.setPackagesToScan("org.example.entities");
            return bean;
        }

        @Bean
        public HibernateTransactionManager transactionManager() throws PropertyVetoException {
            HibernateTransactionManager transactionManager = new HibernateTransactionManager();
            transactionManager.setSessionFactory(sessionFactory().getObject());
            return transactionManager;
        }
    }
}
