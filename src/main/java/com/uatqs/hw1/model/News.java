package com.uatqs.hw1.model;

public class News {
    private String title;
    private String url;
    private String source;
    
    public News(String title, String url, String source) {
        this.title = title;
        this.url = url;
        this.source = source;
    }

    public News() {
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    
}
