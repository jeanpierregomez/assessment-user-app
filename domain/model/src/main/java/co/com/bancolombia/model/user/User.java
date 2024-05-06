package co.com.bancolombia.model.user;
import lombok.*;
//import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String username;
    private String email;
    private BigDecimal balance;
}
