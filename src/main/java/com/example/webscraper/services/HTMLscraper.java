package com.example.webscraper.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URL;

public class HTMLscraper {

    private String url;

    public HTMLscraper(String url){
        this.url = url;
    }

    public String scrape(){
        try{
            URL oracle = new URL(url);
            BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

            String inputLine;
            String temp = "";
            while((inputLine = in.readLine()) != null) {
                temp += inputLine;
            }
            System.out.println(temp);
            return temp;
        }catch (Exception e){
            System.out.println("error in scraping: " + e.getMessage());
        }
        return null;
    }

}

