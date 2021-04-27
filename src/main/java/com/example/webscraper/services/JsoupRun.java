package com.example.webscraper.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class JsoupRun implements CommandLineRunner {

    private String link = "https://news.ycombinator.com";

    @Override
    public void run(String... args) throws Exception {
        Document d = Jsoup.parse("<html><head><title class=\"test1\">First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p></body></html>" +
                "<html><head><title class=\"test1\">First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p></body></html>");
        Elements ele = d.select("title.test1");

        for (int i = 0; i < ele.size(); i++) {
            System.out.println(ele.eq(i));
        }

        Document doc = Jsoup.parse("");

        Element e = doc.selectFirst("table#hnmain");
        System.out.println(e);

    }
}
