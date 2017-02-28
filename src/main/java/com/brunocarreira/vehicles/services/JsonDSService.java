package com.brunocarreira.vehicles.services;

import java.io.IOException;
import java.net.MalformedURLException;

import com.brunocarreira.vehicles.domain.Search;

/*
 * @Author:	Bruno Carreira
 * 
 * JSON DataSource Service Interface
 * 
 */
public interface JsonDSService {
	public Search getSearch() throws MalformedURLException, IOException;
}
