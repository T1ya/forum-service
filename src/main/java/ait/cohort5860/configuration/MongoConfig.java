package ait.cohort5860.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableMongoRepositories(basePackages = "ait.cohort5860.accounting.dao")
@EnableTransactionManagement
public class MongoConfig {
}
