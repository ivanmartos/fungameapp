package com.imartos.fungame.user.repository;

import com.imartos.fungame.user.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findUserByName(String name);

}
