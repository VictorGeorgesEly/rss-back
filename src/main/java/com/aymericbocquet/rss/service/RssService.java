package com.aymericbocquet.rss.service;

import com.aymericbocquet.rss.data.dao.RssFactory;
import com.aymericbocquet.rss.data.dao.RssRepository;
import com.aymericbocquet.rss.data.dto.RssDto;
import com.aymericbocquet.rss.data.entity.Rss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RssService {

    @Autowired
    RssRepository rssRepository;

    @Autowired
    RssFactory rssFactory;

    public List<Rss> getAllRss() {
        return rssRepository.findAll();
    }

    public Rss getRss(Long id) {
        Optional<Rss> rssEntity = rssRepository.findById(id);
        if (rssEntity.isPresent()) {
            return rssEntity.get();
        }
        throw new IllegalArgumentException("could not find the rss with id: " + id);
    }

    public List<Rss> search(String name) {
        return rssRepository.searchRss(name.toLowerCase());
    }

    public Rss createRss(RssDto rssDto) {
        Rss rssEntity = rssFactory.dtoToEntity(rssDto);
        return rssRepository.save(rssEntity);
    }

}
