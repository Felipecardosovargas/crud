package com.teach.crud.service;

import com.teach.crud.dto.request.BookDTOReq;
import com.teach.crud.dto.request.BookPatchDTOReq;
import com.teach.crud.dto.response.BookDTORes;
import com.teach.crud.model.BookModel;
import com.teach.crud.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public final List<BookDTORes> findAllBooks(){
        List<BookModel> list = this.bookRepository.findAll();

        list.forEach(System.out::println);
        return list.stream().map(BookDTORes::modelToDTO).toList();
    }

    public BookDTORes findById(Long id) {

        BookModel bookModel = this.findByIdEntity(id);

        System.out.println(bookModel);

        return BookDTORes.modelToDTO(bookModel);
    }

    public BookDTORes create(BookDTOReq bookDTOReq) {
        BookModel bookModelRes = this.bookRepository.save(bookDTOReq.dtoToModel());
        return BookDTORes.modelToDTO(bookModelRes);
    }

    public BookDTORes update(Long id, BookDTOReq bookDTOReq) {
        BookModel bookModelRes = this.bookRepository.save(bookDTOReq.dtoToModel(id));
        return BookDTORes.modelToDTO(bookModelRes);
    }

    public BookDTORes updateTitle(Long id, BookPatchDTOReq bookPatchDTOReq) {

        BookModel bookModel = this.findByIdEntity(id);

        bookModel.setTitle(bookPatchDTOReq.title());

        BookModel bookModelRes = this.bookRepository.save(bookModel);
        return BookDTORes.modelToDTO(bookModelRes);
    }

    public void delete(Long id) {

        BookModel bookModel = this.findByIdEntity(id);

        this.bookRepository.delete(bookModel);
    }

    private BookModel findByIdEntity(Long id){
        try {
            return this.bookRepository.findById(id).orElseThrow(() -> new ClassNotFoundException("Book not found"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
