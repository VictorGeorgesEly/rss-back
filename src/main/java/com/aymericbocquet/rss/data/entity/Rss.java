package com.aymericbocquet.rss.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rss {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idRss;
    private String path;
    private String name;

    public Rss() {

    }

    public Long getIdRss() {
        return idRss;
    }

    public void setIdRss(Long idRss) {
        this.idRss = idRss;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Rss{" +
                "idRss=" + idRss +
                ", path='" + path + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
