package com.mongo.sample.controller;

import com.mongo.sample.model.Website;
import com.mongo.sample.service.WebsiteService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;
import java.util.List;

@RestController
public class WebsiteController {

	@Autowired
	private WebsiteService websiteService;

	@RequestMapping(value = "/website", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Website save(@RequestBody Website website) {
		websiteService.save(website);
		return website;
	}

	@RequestMapping(value = "/websiteList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Website> getWebsiteList(@QueryParam("page") int page, @QueryParam("size") int size) {
		return websiteService.getWebsiteList(page, size);
	}

	@RequestMapping(value = "/website", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Website get(@QueryParam("name") String name) {
		return websiteService.get(name);
	}
}
