package com.teach.crud.controller;

import com.teach.crud.dto.request.BookDTOReq;
import com.teach.crud.dto.request.BookPatchDTOReq;
import com.teach.crud.dto.response.BookDTORes;
import com.teach.crud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDTORes>> findAllBook(){
        List<BookDTORes> bookModels = this.bookService.findAllBooks();
        return ResponseEntity.ok(bookModels);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTORes> findBookById(@PathVariable("id") Long id){
        BookDTORes bookModel = this.bookService.findById(id);
        return ResponseEntity.ok(bookModel);
    }

    @PostMapping
    public ResponseEntity<BookDTORes> create(@RequestBody BookDTOReq bookDTOReq, UriComponentsBuilder uriComponentsBuilder){
        BookDTORes newBook = this.bookService.create(bookDTOReq);
        URI uri = uriComponentsBuilder.path("/books/{id}").buildAndExpand(newBook.id()).toUri();
        return ResponseEntity.created(uri).body(newBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTORes> update(@PathVariable("id") Long id, @RequestBody BookDTOReq bookDTOReq){
        BookDTORes bookModel1 = this.bookService.update(id, bookDTOReq);
        return ResponseEntity.ok(bookModel1);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BookDTORes> updateTitle(@PathVariable("id") Long id, @RequestBody BookPatchDTOReq bookPatchDTOReq) {
        BookDTORes bookModel = this.bookService.updateTitle(id, bookPatchDTOReq);
        return ResponseEntity.ok(bookModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        this.bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
