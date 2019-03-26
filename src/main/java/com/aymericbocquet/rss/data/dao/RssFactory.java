package com.aymericbocquet.rss.data.dao;

import com.aymericbocquet.rss.data.dto.RssDto;
import com.aymericbocquet.rss.data.entity.Rss;
import org.springframework.stereotype.Component;

@Component
public class RssFactory {

    public Rss dtoToEntity(RssDto rssDto) {
        Rss rssEntity = new Rss();
        rssEntity.setName(rssDto.getName());
        rssEntity.setPath(rssDto.getPath());
        return rssEntity;
    }

}
