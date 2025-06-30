package com.teach.crud.dto.response;

import com.teach.crud.model.BookModel;

public record BookDTORes(Long id, String title, Integer yearPublication) {

    /**
     * @Mapper
     * @param bookModel
     * @return
     */
    public static BookDTORes modelToDTO(BookModel bookModel){
        return new BookDTORes(
                bookModel.getId(),
                bookModel.getTitle(),
                bookModel.getYearPublication()
        );
    };
}
