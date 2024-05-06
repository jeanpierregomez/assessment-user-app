package co.com.bancolombia.model.user;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateBalanceRequest {
    private BigDecimal balance;
    private String userId;
}
