package com.uawebchallenge.service;

import com.redfin.sitemapgenerator.WebSitemapGenerator;
import com.redfin.sitemapgenerator.WebSitemapUrl;
import com.uawebchallenge.common.ChangeFreq;
import com.uawebchallenge.common.WebPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class WebPageServiceImpl implements WebPageService {

    private HashMap<String, WebPage> store = new HashMap<String, WebPage>();

    @Override
    public Boolean validateURL(String url){
        Boolean result = false;
        try{
            new URL(url);
            if(url.contains(".")){
               result = true;
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void createWebPages(String url) {
        String regex0 = "((http:|https:)+/{2}([a-zA-Z0-9]*).([a-zA-Z0-9]*).([a-zA-Z0-9]*).([a-zA-Z0-9]*).(.*[a-zA-Z0-9]*))";
        String regex1 = "((http:|https:)+/{2}([a-zA-Z0-9]*).([a-zA-Z0-9]*).([a-zA-Z0-9]*).([a-zA-Z0-9]*).([a-zA-Z0-9]*)[/{1}](.*[a-zA-Z0-9]*))";
        String regex2 = "((http:|https:)+/{2}([a-zA-Z0-9]*).([a-zA-Z0-9]*).([a-zA-Z0-9]*).([a-zA-Z0-9]*).([a-zA-Z0-9]*)[/{1}]([a-zA-Z0-9]*).*[/{1}](.*[a-zA-Z0-9]*))";
        String regex3 = "((http:|https:)+/{2}([a-zA-Z0-9]*).([a-zA-Z0-9]*).([a-zA-Z0-9]*).([a-zA-Z0-9]*).([a-zA-Z0-9]*)[/{1}]([a-zA-Z0-9]*).*[/{1}]([a-zA-Z0-9]*).*[/{1}](.*[a-zA-Z0-9]*))";

        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements links = doc.select("a[href]");

        for (Element link : links) {
            String tmp = link.attr("abs:href");
            if (tmp.contains(url)) {
                if(tmp.matches(regex0) || tmp.matches(regex1) || tmp.matches(regex2) || tmp.matches(regex3)){
                    WebPage webPage = new WebPage.Builder()
                            .loc(tmp)
                            .lastMod(new Date())
                            .changeFreq(ChangeFreq.WEEKLY)
                            .priority(0.75)
                            .builder();

                    store.put(webPage.getLoc(), webPage);
                }

            }
        }
    }

    @Override
    public void createSiteMap(String url) {

        try {
            WebSitemapGenerator wsg = new WebSitemapGenerator(url, new File("D:"));
            for(Map.Entry<String, WebPage> entry : store.entrySet()){
                WebPage tmpWebPage = entry.getValue();
                WebSitemapUrl tmpUrl = new WebSitemapUrl.Options(tmpWebPage.getLoc())
                        .lastMod(tmpWebPage.getLastMod())
                        .priority(tmpWebPage.getPriority())
                        .changeFreq(com.redfin.sitemapgenerator.ChangeFreq.WEEKLY)
                        .build();
                wsg.addUrl(tmpUrl);
            }
            wsg.write();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        store.clear();
    }
}
