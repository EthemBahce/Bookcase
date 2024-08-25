package com.kitaplik.libraryservice.service;

import com.kitaplik.libraryservice.client.BookServiceClient;
import com.kitaplik.libraryservice.dto.AddBookRequest;
import com.kitaplik.libraryservice.dto.BookDto;
import com.kitaplik.libraryservice.dto.LibraryDto;
import com.kitaplik.libraryservice.exception.LibraryNotFoundException;
import com.kitaplik.libraryservice.model.Library;
import com.kitaplik.libraryservice.repository.LibraryRepository;
import org.apache.tomcat.jni.LibraryNotFoundError;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryService {


    private final LibraryRepository libraryRepository;

    private final BookServiceClient bookServiceClient;

    public LibraryService(LibraryRepository libraryRepository, BookServiceClient bookServiceClient){
        this.libraryRepository = libraryRepository;
        this.bookServiceClient = bookServiceClient;
    }


    public LibraryDto getAllBooksInLibraryById(String id){

        Library library = libraryRepository.findById(id)
                .orElseThrow(() -> new LibraryNotFoundException("Library could not found by id:" + id));



        /*List<BookDto> bookDtoList = library.getUserBook()
                .stream()
                .map(x-> bookServiceClient.getBookById(x).getBody())
                .collect(Collectors.toList());*/

        LibraryDto libraryDto = new LibraryDto(library.getId(),library.getUserBook()
                .stream()
                .map(x -> bookServiceClient.getBookById(x))
                .map(ResponseEntity::getBody)
                .collect(Collectors.toList()));


        return libraryDto;

    }

    public LibraryDto createLibrary(){

        Library library = new Library();
        Library newLibrary = libraryRepository.save(library);



        LibraryDto libraryDto = new LibraryDto(newLibrary.getId());

        return libraryDto;

    }

    public void addBookToLibrary(AddBookRequest request){

        //feign client ile kitap isbn numarasını getirdik ve return ettiğimiz değeri bir string değişkene atadık
        String bookId = bookServiceClient.getBookByIsbn(request.getIsbn()).getBody().getBookId();

        Library library = libraryRepository.findById(request.getId())
                .orElseThrow(() -> new LibraryNotFoundException("Library could not found by id:" + request.getId()));

        library.getUserBook().add(bookId);

        libraryRepository.save(library);

    }

    public List<String> getAllLibraries() {
        return libraryRepository.findAll()
                .stream()
                .map(l -> l.getId())
                .collect(Collectors.toList());
    }


/*List<BookDto> list = new ArrayList<>();
        for (String s : library.getUserBook()) {
            ResponseEntity<BookDto> bookById = bookServiceClient.getBookById(s);
            BookDto body = bookById.getBody();
            list.add(body);
        }
        LibraryDto libraryDto = new LibraryDto(library.getId(),
                list
        );*/


}
