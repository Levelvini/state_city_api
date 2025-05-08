package com.levelvini.test_dev.repository;

import com.levelvini.test_dev.model.City;
import com.levelvini.test_dev.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends BaseRepository<City> {
    @Query("SELECT c.name FROM City as c WHERE id = CityId")
    public City findByState(String StateId,String CityId);
}
