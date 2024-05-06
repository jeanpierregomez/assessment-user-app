package co.com.bancolombia.model.kafkaproducer;

import co.com.bancolombia.model.log.Log;

public interface KafkaProducerRepository {
    public void sendMessage(Log message);
}
