package com.example.webscraper.services;

import com.example.webscraper.models.Data;
import com.example.webscraper.models.Request;
import com.example.webscraper.repositories.DataRepository;
import com.example.webscraper.repositories.RequestRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JsoupServiceImpl implements JsoupService{

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    DataRepository dataRepository;

    public Request getData(Request request){
        requestRepository.save(request);

        HTMLscraper scrape = new HTMLscraper(request.getLink());
        String html = scrape.scrape();

        Document document = Jsoup.parse(html);
        Elements elements = document.select(request.getParameter());

        for (int i = 0; i < elements.size(); i++){
            Data data = new Data(elements.eq(i).toString(), request);
            dataRepository.save(data);
        }

        return requestRepository.getOne(request.getId());
    }
}
