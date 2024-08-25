package com.kitaplik.bookservice;

import com.kitaplik.bookservice.model.Book;
import com.kitaplik.bookservice.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class BookServiceApplication implements CommandLineRunner {

	private final BookRepository bookRepository;
	public BookServiceApplication(BookRepository bookRepository){
		this.bookRepository = bookRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Book book1 = new Book();
		book1.setTitle("Das Capital");
		book1.setBookYear(1865);
		book1.setAuthor("Karl Marx");
		book1.setPressName("aaaaaa");
		book1.setIsbn("10a");
		Book book2 = new Book();
		book2.setTitle("Kavgam");
		book2.setBookYear(1928);
		book2.setAuthor("Adolf Hitler");
		book2.setPressName("bbbbbb");
		book2.setIsbn("20b");
		Book book3 = new Book();
		book3.setTitle("Nutuk");
		book3.setBookYear(1924);
		book3.setAuthor("Mustafa Kemal Atatürk");
		book3.setPressName("cccccc");
		book3.setIsbn("30c");
		Book book4 = new Book("","Sapiens",2014,"Harari","dddddd","40d");
		/*book3.setTitle("Sapiens");
		book3.setBookYear(2014);
		book3.setAuthor("Harari");
		book3.setPressName("dddddd");
		book3.setIsbn("d10");*/




		List<Book> bookList = bookRepository.saveAll(Arrays.asList(book1,book2,book3,book4));

		   for (int i = 0; i < bookList.size(); i++){
			   System.out.println(bookList.get(i).getBookId());
			   System.out.println(bookList.get(i).getTitle());
			   System.out.println(bookList.get(i).getBookYear());
			   System.out.println(bookList.get(i).getAuthor());
			   System.out.println(bookList.get(i).getPressName());
			   System.out.println(bookList.get(i).getIsbn());
			   System.out.println(bookList.get(i).getClass());
		   }

			System.out.println(bookList);



	}
}
