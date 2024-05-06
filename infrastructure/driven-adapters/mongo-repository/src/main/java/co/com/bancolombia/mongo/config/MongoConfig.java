package co.com.bancolombia.mongo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mongo.MongoConnectionDetails;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.autoconfigure.mongo.PropertiesMongoConnectionDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MongoConfig {

    @Bean
    public MongoDBSecret dbSecret(@Value("${spring.data.mongodb.uri}") String uri, @Value("${spring.data.mongodb.auto-index-creation}") boolean autoIndexCreation) {
        return MongoDBSecret.builder()
                .uri(uri)
                .autoIndexCreation(autoIndexCreation)
                .build();
    }

    @Bean
    public MongoConnectionDetails mongoProperties(MongoDBSecret secret) {
        MongoProperties properties = new MongoProperties();
        properties.setUri(secret.getUri());
        properties.setAutoIndexCreation(secret.isAutoIndexCreation());
        return new PropertiesMongoConnectionDetails(properties);
    }
}
