package com.levelvini.test_dev.repository;

import com.levelvini.test_dev.model.State;
import com.levelvini.test_dev.repository.base.BaseRepository;
import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends BaseRepository<State> {
}
