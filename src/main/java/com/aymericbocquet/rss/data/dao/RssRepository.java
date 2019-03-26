package com.aymericbocquet.rss.data.dao;

import com.aymericbocquet.rss.data.entity.Rss;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RssRepository extends CrudRepository<Rss, Long> {

    List<Rss> findAll();

    @Query("select s from Rss s where s.name like %?1%")
    List<Rss> searchRss(String name);

}
