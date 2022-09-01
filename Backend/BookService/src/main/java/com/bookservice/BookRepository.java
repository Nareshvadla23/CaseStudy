package com.bookservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookservice.entity.Book;
import com.bookservice.responseentity.Sbook;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query("select b.image,b.title,b.category,b.price,b.publisher,b.publisherDate,a.name from  Book b join b.author a where b.catergory=?1 and b.price=?2 and b.publisher=?3")
	public List<Sbook> getBooks(String category, Double price, String publisher);

}
