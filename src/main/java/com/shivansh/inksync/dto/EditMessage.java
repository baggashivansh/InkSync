package com.shivansh.inksync.dto;

public class EditMessage {

    private String docId;
    private String content;

    public EditMessage() {
    }

    public EditMessage(String docId, String content) {
        this.docId = docId;
        this.content = content;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}