package com.aymericbocquet.rss.data.dto;

public class RssDto {

    private Long idRss;
    private String path;
    private String name;

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
}
