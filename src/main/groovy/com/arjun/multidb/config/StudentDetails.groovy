package com.arjun.multidb.config

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="student_details")
class StudentDetails {

    @Column(name="stu_id")
    @Id
    @GeneratedValue
    Integer id

    @Column(name="stu_name")
    String name

    @Column(name="stu_city")
    String city

    @Column(name="stu_parent_id")
    Integer parent

}
