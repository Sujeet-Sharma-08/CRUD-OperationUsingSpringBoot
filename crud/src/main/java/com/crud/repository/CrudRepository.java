package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.Entity.CrudEntity;

public interface CrudRepository extends JpaRepository<CrudEntity , Long> {
}
