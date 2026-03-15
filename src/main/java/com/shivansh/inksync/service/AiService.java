package com.shivansh.inksync.service;

import org.springframework.stereotype.Service;

@Service
public class AiService {

    public String summarize(String content) {

        if (content == null || content.trim().isEmpty()) {
            return "Nothing to summarize.";
        }

        content = content.trim();

        if (content.length() <= 120) {
            return content;
        }

        return content.substring(0, 120) + "...";
    }
}