package com.shivansh.inksync.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class DocumentService {

    private final Map<String, String> documents = new ConcurrentHashMap<>();

    public String getDocument(String docId) {

        return documents.getOrDefault(docId, "");
    }

    public void updateDocument(String docId, String content) {

        documents.put(docId, content);
    }
}