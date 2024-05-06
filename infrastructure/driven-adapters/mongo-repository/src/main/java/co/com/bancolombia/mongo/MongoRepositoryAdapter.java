package co.com.bancolombia.mongo;

import co.com.bancolombia.model.user.User;
import co.com.bancolombia.model.user.gateways.UserRepository;
import co.com.bancolombia.mongo.helper.AdapterOperations;
import co.com.bancolombia.mongo.user.UserEntity;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MongoRepositoryAdapter extends AdapterOperations<User, UserEntity, String, MongoDBRepository>
implements UserRepository {
    private Object CacheNamesConstants;

    public MongoRepositoryAdapter(MongoDBRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, User.class/* change for domain model */));
    }

    @Override
    public User saveUser(User user) {
        return this.save(user);
    }

    @Override
    public void deleteUser(String id) {
        this.repository.deleteById(id);
    }

    @Override
    public User getUser(String id) {
        return this.findById(id);
    }

    @Override
    @Cacheable(cacheNames = "USERS")
    public List<User> getUsers() {
        return this.findAll();
    }
}
