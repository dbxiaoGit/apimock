package com.test.service;

import com.test.entity.PeopleInfo;
import com.test.entity.TestEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Derek on 2017/12/22.
 */

@Service
public class MockService {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TestEntity testEntity;

    public PeopleInfo getPeopleInfoRandom(){
        logger.info("MockService.getPeopleInfoRandom()");
        int num = (int) (3* Math.random());
        logger.info("num : {}",num);
        return testEntity.getPeopleList().get(num);
    }

    public List<PeopleInfo> getPeopleInfoByJson(PeopleInfo peopleInfo){
        logger.info("MockService.getPeopleInfoByJson()");
        logger.info("peopleInfo.name:{}",peopleInfo.getName());
        peopleInfo.getClass().getDeclaredMethods();
        List<PeopleInfo> resultList =testEntity.getPeopleList() ;

        if(peopleInfo.getName() != null){
            resultList = resultList.stream().filter(item ->
                item.getName().equals(peopleInfo.getName())
            ).collect(Collectors.toList());
        }
        if(peopleInfo.getAge() != 0){
            resultList = resultList.stream().filter(item ->
                    item.getAge() == (peopleInfo.getAge())
            ).collect(Collectors.toList());
        }
        if(peopleInfo.getCompanyName() != null){
            resultList = resultList.stream().filter(item ->
                    item.getCompanyName().equals(peopleInfo.getCompanyName())
            ).collect(Collectors.toList());
        }
        if(peopleInfo.getDepartment() != null){
            resultList = resultList.stream().filter(item ->
                    item.getDepartment().equals(peopleInfo.getDepartment())
            ).collect(Collectors.toList());
        }
        if(peopleInfo.getRole() != null){
            resultList = resultList.stream().filter(item ->
                    item.getRole().equals(peopleInfo.getRole())
            ).collect(Collectors.toList());
        }

        return resultList;
    }
}
