package com.teach.crud.dto.request;

import com.teach.crud.model.BookModel;

public record BookDTOReq(String title, Integer yearPublication) {

    public BookModel dtoToModel(){

        return new BookModel(this.title(), this.yearPublication());
    }

    public BookModel dtoToModel(Long id){

        return new BookModel(id, this.title(), this.yearPublication());
    }
}
