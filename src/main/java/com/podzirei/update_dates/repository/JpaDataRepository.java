package com.podzirei.update_dates.repository;

import com.podzirei.update_dates.entity.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaDataRepository extends JpaRepository<Data, Integer> {
    @Override
    Page<Data> findAll(Pageable pageable);

}
