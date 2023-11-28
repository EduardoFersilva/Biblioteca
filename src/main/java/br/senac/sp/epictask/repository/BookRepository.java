package br.senac.sp.epictask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.sp.epictask.Model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
    
}
