package com.shivansh.inksync.controller;

import com.shivansh.inksync.service.DocumentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/{docId}")
    public String getDocument(@PathVariable String docId) {

        return documentService.getDocument(docId);
    }
}