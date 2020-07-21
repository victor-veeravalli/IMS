/*
 * package com.inventory.management.config;
 * 
 * import
 * org.springframework.cloud.aws.jdbc.config.annotation.EnableRdsInstance;
 * import
 * org.springframework.cloud.aws.jdbc.config.annotation.RdsInstanceConfigurer;
 * import
 * org.springframework.cloud.aws.jdbc.datasource.TomcatJdbcDataSourceFactory;
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration;
 * 
 * @Configuration
 * 
 * @EnableRdsInstance( dbInstanceIdentifier = "database-1", password =
 * "admin123")
 * 
 * public class AWSRdsConfig {
 * 
 * 
 * 
 * @Bean public RdsInstanceConfigurer instanceConfigurer() { return () -> {
 * TomcatJdbcDataSourceFactory dataSourceFactory = new
 * TomcatJdbcDataSourceFactory(); dataSourceFactory.setInitialSize(10);
 * dataSourceFactory.setValidationQuery("SELECT 1"); return dataSourceFactory;
 * }; } }
 * 
 */