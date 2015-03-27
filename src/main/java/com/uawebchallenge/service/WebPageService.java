package com.uawebchallenge.service;

public interface WebPageService {

    Boolean validateURL(String url);

    void createWebPages(String url);

    String createSiteMap(String url);
}
