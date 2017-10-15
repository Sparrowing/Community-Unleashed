package bwphackstl17.unleashed.entities.access;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bwphackstl17.unleashed.entities.Event;

@Transactional
@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {

	List<Event> findById(int it);
	List<Event> findAll();
}
