package com.arjun.multidb.config

import org.springframework.data.jpa.repository.JpaRepository

interface SqlInterface extends JpaRepository<StudentDetails,Integer>{

}
