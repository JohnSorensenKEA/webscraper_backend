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
        HTMLscraper scrape = new HTMLscraper("https://news.ycombinator.com/");
        Document doc = Jsoup.parse(scrape.scrape());

//        Element e = doc.selectFirst("table#hnmain");
        Elements e = doc.select("a.storylink");
        Elements el = doc.select("span.rank");
        Elements els = doc.select("span.age");
        for(int i = 0; i<e.size(); i++){
            System.out.println("Rank: " + el.eq(i).text());
            System.out.println("Titel: " + e.eq(i).text());
            System.out.println("Link: " + e.eq(i).attr("href"));
            System.out.println(els.eq(i).text());
            System.out.println("\n");
        }


//        System.out.println(e);

    }
}
