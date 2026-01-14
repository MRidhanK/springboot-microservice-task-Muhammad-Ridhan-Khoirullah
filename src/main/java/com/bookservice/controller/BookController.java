package com.bookservice.controller;

import com.bookservice.model.Book;
import com.bookservice.service.BookService;
import com.bookservice.dto.ApiResponse;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Book>> create(@RequestBody Book book){
        Book saved = service.save(book);
        return ResponseEntity.ok(
            new ApiResponse<>("Book created successfully", saved)
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Book>>> getAll(){
        return ResponseEntity.ok(
            new ApiResponse<>("Books retrieved successfully", service.findAll())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Book>> getById(@PathVariable Long id){
        return ResponseEntity.ok(
            new ApiResponse<>("Book retrieved successfully", service.findById(id))
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Book>> update(
            @PathVariable Long id,
            @RequestBody Book book){

        Book b = service.findById(id);
        b.setTitle(book.getTitle());
        b.setAuthor(book.getAuthor());
        b.setIsbn(book.getIsbn());
        b.setPublishedDate(book.getPublishedDate());

        return ResponseEntity.ok(
            new ApiResponse<>("Book updated successfully", service.save(b))
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<Book>> patch(
            @PathVariable Long id,
            @RequestBody Map<String,String> data){

        Book b = service.findById(id);
        if(data.containsKey("title")) {
            b.setTitle(data.get("title"));
        }

        return ResponseEntity.ok(
            new ApiResponse<>("Book updated successfully", service.save(b))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok(
            new ApiResponse<>("Book deleted successfully", null)
        );
    }
}

