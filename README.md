# SpringDataMultiDB
Spring Boot with Data for connecting Multiple Datasource

In this sample, H2 In Memory Database & MySQL were configured

In order to use multiple datasources, we need to configure Entity Manager, Transaction Manager & Datasource. Also make sure you declare at least one connection as primary using @Primary annotation

Sample Configuration for H2 Database

```
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "myh2EntityManager",
        transactionManagerRef = "myh2TransactionManager",
        basePackages = "com.arjun.multidb.h2config"
)
class MyH2Config {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource myH2DataSource() {
        return DataSourceBuilder
                .create()
                .build();
    }

    @Primary
    @Bean(name = "myh2EntityManager")
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(myH2DataSource())
                .packages(MyQuery.class)
                .persistenceUnit("h2PU")
                .build();
    }

    @Primary
    @Bean(name = "myh2TransactionManager")
    public PlatformTransactionManager mysqlTransactionManager(@Qualifier("myh2EntityManager") EntityManagerFactory entityManagerFactory {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
```
