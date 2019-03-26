package com.aymericbocquet.rss.controller;

import com.aymericbocquet.rss.data.dto.RssDto;
import com.aymericbocquet.rss.data.entity.Rss;
import com.aymericbocquet.rss.service.RssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rss")
public class RssController {

    @Autowired
    RssService rssService;

    @GetMapping
    public List<Rss> getAllRss() {
        return rssService.getAllRss();
    }

    @GetMapping("/{id}")
    public Rss getRss(@PathVariable Long id) {
        return rssService.getRss(id);
    }

    @GetMapping("/search")
    public List<Rss> searchRss(String name) {
        return rssService.search(name);
    }

    @PostMapping()
    public Rss createRss(@RequestBody RssDto rssDto) {
        return rssService.createRss(rssDto);
    }

}
