package bwphackstl17.unleashed.entities.access;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bwphackstl17.unleashed.entities.User;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	User findById(int id);
	User findByUsername(String username);
}
