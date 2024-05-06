package co.com.bancolombia.kafkaproducer;

import co.com.bancolombia.model.kafkaproducer.KafkaProducerRepository;
import co.com.bancolombia.model.log.Log;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Component;
import java.util.Random;

@Component
@AllArgsConstructor
public class KafkaProducerAdapter implements KafkaProducerRepository {

    private final Producer<String, Log> producer;

    @Override
    public void sendMessage(Log message) {
        String topic = "put-logs";
        producer.send(new ProducerRecord<String, Log>(topic, "a" + new Random().nextInt(10000), message));
    }
}
