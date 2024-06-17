package com.tu_usuario.literatula.repository;

import com.tu_usuario.literatula.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
