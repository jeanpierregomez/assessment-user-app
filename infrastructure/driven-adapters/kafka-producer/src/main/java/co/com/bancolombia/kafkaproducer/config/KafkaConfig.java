package co.com.bancolombia.kafkaproducer.config;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class KafkaConfig {
    private String topic;
    private String boostrapServers;
}
