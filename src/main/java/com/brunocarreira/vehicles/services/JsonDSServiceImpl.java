package com.brunocarreira.vehicles.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.brunocarreira.vehicles.domain.Search;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * @Author:	Bruno Carreira
 * 
 * JSON DataSource Service Implementation Class
 * 
 * Retrieve Vehicle list objects from JSON URL.
 */
@Component
public class JsonDSServiceImpl implements JsonDSService{

	// Read from application.properties
	@Autowired
    private Environment env;

	private Search search;
	
	public Search getSearch() throws MalformedURLException, IOException {
		if(search==null){
			String url = env.getProperty("datasource.url");

    		ObjectMapper mapper = new ObjectMapper();
    		JsonNode root = mapper.readTree(new URL(url));
    		JsonNode searchNode = root.get("Search");
    		search = mapper.convertValue(searchNode, Search.class);
		}
		
		return search;
	}
    
    
}
