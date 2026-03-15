package com.shivansh.inksync.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Note {

    @Id
    private String id;

    @Column(length = 20000)
    private String content;

    private long lastUpdated;

    public Note() {
    }

    public Note(String id, String content, long lastUpdated) {
        this.id = id;
        this.content = content;
        this.lastUpdated = lastUpdated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}