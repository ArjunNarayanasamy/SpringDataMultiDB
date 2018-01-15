package com.arjun.multidb

import com.arjun.multidb.config.SqlInterface
import com.arjun.multidb.config.StudentDetails
import com.arjun.multidb.h2config.MyQuery
import com.arjun.multidb.h2config.QueryInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController {

    @Autowired
    QueryInterface queryInterface

    @Autowired
    SqlInterface sqlInterface

    @RequestMapping(value = "/usecase", method = RequestMethod.GET)
    List<MyQuery> getQueueByUsecase(@RequestParam String name){
        List<MyQuery> myQueries = queryInterface.findByUsecase(name)
        myQueries
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    List<StudentDetails> getStudent(){
        List<StudentDetails> details = sqlInterface.findAll()
        details
    }
}
