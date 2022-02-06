package simongumis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import simongumis.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

}
