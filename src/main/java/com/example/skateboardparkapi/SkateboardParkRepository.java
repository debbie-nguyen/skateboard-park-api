package com.example.skateboardparkapi;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface  SkateboardParkRepository extends CrudRepository<SkateboardPark, Long> {

    SkateboardPark findById(long id);

    SkateboardPark findByName(String Name);

}
