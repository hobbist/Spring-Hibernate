package com.tutorial.config;

import com.tutorial.model.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(value = {"com.tutorial.model", "com.tutorial.service", "com.tutorial.dao"})
@EnableTransactionManagement

public class ApplicationConfig {

    @Bean(name = "h2Db")
    public DataSource getDataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        //return builder.setType(EmbeddedDatabaseType.H2).addScript("script.sql").build();
        return builder.setType(EmbeddedDatabaseType.H2).build();
    }

    @Bean("sessionFactory")
    @DependsOn(value = "h2Db")
    public SessionFactory getSessionFactory(@Qualifier("h2Db") DataSource dataSource) {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
        builder.addProperties(getProperties());
        builder.addAnnotatedClasses(User.class,Address.class,Credentials.class);
        builder.addAnnotatedClasses(Vehicle.class, TwoWheeler.class,FourWheeler.class);
        return builder.buildSessionFactory();
    }

    @Bean("transX")
    @DependsOn("sessionFactory")
    public HibernateTransactionManager getTranscationMananger(@Qualifier("sessionFactory") SessionFactory factory) {
        return new HibernateTransactionManager(factory);
    }

    private Properties getProperties() {
        Properties props = new Properties();
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.hbm2ddl.auto","create");
        props.setProperty("hibernate.cache.use_query_cache", "true");
        props.setProperty("hibernate.cache.user_second_level_cache","true");
        props.setProperty("hibernate.cache.region.factory_class","org.hibernate.cache.ehcache.EhCacheRegionFactory");
        return props;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor getTranslator() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
