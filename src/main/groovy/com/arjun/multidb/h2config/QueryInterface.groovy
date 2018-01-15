package com.arjun.multidb.h2config

import org.springframework.data.jpa.repository.JpaRepository

interface QueryInterface extends JpaRepository<MyQuery, Integer> {

    List<MyQuery> findByUsecase(String usecase)
}