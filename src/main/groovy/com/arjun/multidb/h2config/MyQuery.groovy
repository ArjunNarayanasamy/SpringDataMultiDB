package com.arjun.multidb.h2config

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="Queries")
class MyQuery {

    @Id
    @GeneratedValue
    @Column(name="id")
    Integer id

    @Column(name="usecase")
    String usecase

    @Column(name="query")
    String query
}
