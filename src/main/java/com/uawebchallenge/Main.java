package com.uawebchallenge;

import com.uawebchallenge.service.WebPageServiceImpl;

public class Main {
    public static void main(String[] args) {
        WebPageServiceImpl webPageService = new WebPageServiceImpl();


        String s0 = "((http:|https:)+/{2}([a-zA-Z0-9]*).([a-zA-Z0-9]*).([a-zA-Z0-9]*).([a-zA-Z0-9]*).([a-zA-Z0-9]*)[/{1}].*)";
        String s1 = "((http:|https:)+/{2}([a-zA-Z0-9]*).([a-zA-Z0-9]*).([a-zA-Z0-9]*).([a-zA-Z0-9]*).([a-zA-Z0-9]*)[/{1}]([a-zA-Z0-9]+).*)";
        String s2 = "((http:|https:)+/{2}([a-zA-Z0-9]+).([a-zA-Z0-9]+).([a-zA-Z0-9]+).([a-zA-Z0-9]+).([a-zA-Z0-9]+)[/{1}]([a-zA-Z0-9]+).*[/{1}]([a-zA-Z0-9]+).*)";
        String s3 = "(^(http:|https:)+/{2}([a-zA-Z0-9]+).([a-zA-Z0-9]+).([a-zA-Z0-9]+).([a-zA-Z0-9]+).([a-zA-Z0-9]+)[/{1}]([a-zA-Z0-9]+).*[/{1}]([a-zA-Z0-9]+).*[/{1}]([a-zA-Z0-9]+).*)";

        if("http://i.ua/".matches(s0)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }if("http://ddssscsdc.ua.au/sds12s_dsd/asd".matches(s2)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }if("http://ddss.scs-dc.ua.au/sd?ss_dsd/ss_ds_?d/asd".matches(s3)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

    }
}
