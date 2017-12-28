package com.test.controller;

import com.test.entity.PeopleInfo;
import com.test.service.MockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Derek on 2017/12/22.
 */

@RestController
public class MockController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MockService mockService;

    @RequestMapping(value="/getPeopleInfoRandom" ,produces="application/json;charset=UTF-8")
    public PeopleInfo getPeopleInfoRandom(){
        logger.info("get request /getPeopleInfoRandom");
        return mockService.getPeopleInfoRandom();
    }

    @RequestMapping(value="/getPeopleInfoByJson" ,produces="application/json;charset=UTF-8")
    public List<PeopleInfo> getPeopleInfoByJson(@RequestBody PeopleInfo peopleInfo){
        logger.info("get request /getPeopleInfoByJson");
        return mockService.getPeopleInfoByJson(peopleInfo);
    }
}
