package com.levelvini.test_dev.repository;

import com.levelvini.test_dev.model.State;
import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, UUID> {
}
