package com.uawebchallenge.service;

public interface WebPageService {

    Boolean validateURL(String url);

    void createWebPages(String url);

    void createSiteMap(String url);
}
