package co.com.bancolombia.api;
import co.com.bancolombia.model.user.UpdateBalanceRequest;
import co.com.bancolombia.model.user.User;
import co.com.bancolombia.usecase.user.UserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final UserUseCase userUseCase;

    @GetMapping(path = "/")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userUseCase.getUsers());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") String id) {
        return ResponseEntity.ok(userUseCase.getUser(id));
    }

    @PostMapping(path = "/")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userUseCase.saveUser(user));
    }

    @PatchMapping(path = "/")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userUseCase.updateUser(user));
        } catch (Exception e) {
            return new ResponseEntity<User>(new User(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") String id) {
        userUseCase.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping(path = "/balance")
    public ResponseEntity<User> updateBalance(@RequestBody UpdateBalanceRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userUseCase.updateBalance(request.getUserId(), request.getBalance()));
        } catch (Exception e) {
            return new ResponseEntity<User>(new User(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
