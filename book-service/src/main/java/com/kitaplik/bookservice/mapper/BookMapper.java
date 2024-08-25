package com.kitaplik.bookservice.mapper;


import com.kitaplik.bookservice.dto.BookDto;
import com.kitaplik.bookservice.dto.BookIdDto;
import com.kitaplik.bookservice.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);



     BookDto bookToBookDto(Book book);
     Book bookDtoToBook(BookDto bookDto);

     BookIdDto bookIdDto(Book book);
     Book bookIdDtoBook(BookIdDto bookIdDto);



}
