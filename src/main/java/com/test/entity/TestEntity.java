package com.test.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by Derek on 2017/12/22.
 */

@Component
@ConfigurationProperties(prefix="peopleInfos")
public class TestEntity {
    private ArrayList<PeopleInfo> peopleList ;

    public ArrayList<PeopleInfo> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(ArrayList<PeopleInfo> peopleList) {
        this.peopleList = peopleList;
    }
}
