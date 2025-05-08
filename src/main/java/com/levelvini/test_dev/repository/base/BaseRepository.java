package com.levelvini.test_dev.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<T> extends JpaRepository<T,String> {
}
