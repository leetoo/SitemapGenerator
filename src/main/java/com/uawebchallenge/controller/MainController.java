package com.uawebchallenge.controller;

import com.uawebchallenge.service.WebPageService;
import com.uawebchallenge.service.WebPageServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    private WebPageService webPageService = new WebPageServiceImpl();

    @RequestMapping(value = "/form.html", method = RequestMethod.GET)
    public ModelAndView getForm(){
        ModelAndView modelAndView = new ModelAndView("Form");
        return modelAndView;
    }

    @RequestMapping(value = "/form.html", method = RequestMethod.POST)
    public ModelAndView successForm(@RequestParam("url") String url){
        ModelAndView result = null;
        if(webPageService.validateURL(url)){
            ModelAndView modelAndView = new ModelAndView("SuccessForm");
            webPageService.createWebPages(url);
            String s = webPageService.createSiteMap(url);
            modelAndView.addObject("msg", s);
            result = modelAndView;
        }else{
            ModelAndView modelAndView = new ModelAndView("Form");
            modelAndView.addObject("msg", "Invalid URL, try again!");
            result = modelAndView;
        }
        return result;
    }
}
