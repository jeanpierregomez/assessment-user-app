package co.com.bancolombia.model.log;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Log {
    private String id;
    private String timestamp;
    private String log;

    public Log(String timestamp, String log) {
        this.timestamp = timestamp;
        this.log = log;
    }

}
