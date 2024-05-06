package co.com.bancolombia.mongo.user;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document("user")
public class UserEntity {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String username;
    @Indexed(unique = true)
    private String email;
    private BigDecimal balance;
}
