package co.com.bancolombia.mongo;

import co.com.bancolombia.mongo.user.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface MongoDBRepository extends MongoRepository<UserEntity, String> , QueryByExampleExecutor<UserEntity> {
}
