package com.mongo.sample.controller;

import com.mongo.sample.model.Order;
import com.mongo.sample.model.Website;
import com.mongo.sample.service.WebsiteService;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyByte;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;

/**
 * Created by srikanth on 23/12/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class WebsiteControllerTest {
    @InjectMocks
    private WebsiteController websiteController;
    @Mock
    private WebsiteService websiteService;

    @Test
    public void save() throws Exception {
        Website website = new Website();
        Mockito.doNothing().when(websiteService).save(website);
        websiteController.save(website);
        Mockito.verify(websiteService, times(1)).save(website);
    }

    @Test
    public void getWebsiteList() throws Exception {
        List<Website> list = new ArrayList<>();
        Website website = new Website();
        list.add(website);
        website = new Website();
        list.add(website);
        Mockito.when(websiteService.getWebsiteList(anyInt(), anyInt())).thenReturn(list);
        List websiteList = websiteController.getWebsiteList(1, 2);
        Mockito.verify(websiteService, times(1)).getWebsiteList(anyInt(), anyInt());
        assertEquals(websiteList.size(), 2);
    }

    @Test
    public void get() throws Exception {
        Website website = new Website();
        Mockito.when(websiteService.get(any())).thenReturn(website);
        Website websiteResponse = websiteController.get("123");
        Mockito.verify(websiteService, times(1)).get(any());
    }

}