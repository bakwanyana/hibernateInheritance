package com.modjadji.persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.modjadji.persistence.repository")
public class JPAConfig {

    /* configure wrapper around JPA EntityManagerFactory: constructs EntityManager */
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean inMemoryEntityManagerFactory(DataSource dataSource,
                                                                               JpaVendorAdapter vendorAdapter,
                                                                               LoadTimeWeaver loadTimeWeaver,
                                                                               Properties hibernateProperties) {

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setJpaVendorAdapter(vendorAdapter);
        em.setLoadTimeWeaver(loadTimeWeaver);
        em.setJpaProperties(hibernateProperties);
        em.setPackagesToScan("com.modjadji.persistence.domain"); // auto-include @Entity annotated classes ; alternative to declaring PersistenceUnit via persistence.xml
        return em;
    }

    /* data source configuration */
    @Bean
    public DataSource dataSourceInMemory() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=FALSE");
        dataSource.setUsername("");
        dataSource.setPassword("");
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter vendorAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
        vendorAdapter.setGenerateDdl(true); // generate tables
        vendorAdapter.setShowSql(true); // generated sql logging at INFO level
        return vendorAdapter;
    }

    @Bean
    public LoadTimeWeaver loadTimeWeaver() {
        return new InstrumentationLoadTimeWeaver();
    } //used by LocalContainerEntityManagerFactoryBean at class load time to enable AOP functionality

    @Bean
    Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "create"); // destroy existing data and schema and create new one
        properties.setProperty("hibernate.show_sql", "true"); // log queries
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.import_files", "initial_data.sql"); // run initial_data.sql on startup
        properties.setProperty("hibernate.hbm2ddl.import_files_sql_extractor", "org.hibernate.tool.hbm2ddl.MultipleLinesSqlCommandExtractor");
        return properties;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf, DataSource dataSource) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

    /* H2 configs*/

    @Bean(initMethod="start", destroyMethod="stop")
    public org.h2.tools.Server h2WebServer() throws SQLException {
        return org.h2.tools.Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082");
    }

    @Bean(initMethod="start", destroyMethod="stop")
    @DependsOn(value = "h2WebServer")
    public org.h2.tools.Server h2Server() throws SQLException {
        return org.h2.tools.Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
    }
}
