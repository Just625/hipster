package vn.neo.api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import vn.neo.api.domain.Book;

/**
 * Spring Data SQL repository for the Book entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("select book from Book book where book.manytoone.login = ?#{principal.username}")
    List<Book> findByManytooneIsCurrentUser();
}
