package com.mongo.sample.service;

import com.mongo.sample.dao.WebsiteDao;
import com.mongo.sample.dao.WebsitePagingRepository;
import com.mongo.sample.model.Website;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class WebsiteService {
    @Autowired
    private WebsiteDao websiteDao;

    @Autowired
    private MongoOperations mongoTemplate;

    @Autowired
    private WebsitePagingRepository websitePagingRepository;

    public void save(Website website) {
        websiteDao.insert(website);
    }

    public List<Website> getWebsiteList(int page, int size) {
        Pageable pageable = new PageRequest(page, size);
        Query query = new Query();
        query.with(pageable);
        List<Website> websites =  mongoTemplate.find(query, Website.class);
        return  websites;
    }

    public Website get(String name) {
        return mongoTemplate.findOne(query(where("name").is(name)), Website.class);
    }
}
