package com.fl0.surl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class Controller {
    @Autowired
    private UrlRepository repository;

    @GetMapping("/get")
    List<UrlEntity> getAll(){
        return repository.findAll();
    }

    @GetMapping("/create")
    UrlEntity createNew(){
        UrlEntity e = new UrlEntity();
        e.setUrl(getRandomUrl());
        e.setCount(getRendomInt());
        repository.save(e);
        return e;
    }

    @GetMapping("/delete")
    String deleteAll(){
        repository.deleteAll();
        return "deleted all";
    }


    String getRandomUrl(){
        List<String> urlList = new ArrayList<>();
        urlList.add("https://www.example1.com");
        urlList.add("https://www.example2.com");
        urlList.add("https://www.example3.com");
        urlList.add("https://www.example4.com");
        urlList.add("https://www.example5.com");
        urlList.add("https://www.example6.com");
        urlList.add("https://www.example7.com");
        urlList.add("https://www.example8.com");
        urlList.add("https://www.example9.com");
        urlList.add("https://www.example10.com");

        // Select a random URL from the list
        Random random = new Random();
        String randomUrl = urlList.get(random.nextInt(urlList.size()));
        return randomUrl;
    }

    Integer getRendomInt(){
        Random random = new Random();
        return random.nextInt(1000);
    }
}
