package com.mongo.sample.dao;

import com.mongo.sample.model.Website;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by srikanth on 22/12/16.
 */
@Repository
public interface WebsitePagingRepository extends PagingAndSortingRepository<Website, Long> {


}

