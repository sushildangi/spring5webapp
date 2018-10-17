package org.pyarts.spring5webapp.bootstrap;

import org.pyarts.spring5webapp.model.Author;
import org.pyarts.spring5webapp.model.Book;
import org.pyarts.spring5webapp.repositories.AuthorRepository;
import org.pyarts.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initDate();
    }

    private void initDate() {
        Author sushil = new Author("Sushil", "Dangi");
        Book jProgramming = new Book("Java In Action", "123456", "My Own Publication");
        sushil.getBooks().add(jProgramming);
        jProgramming.getAuthors().add(sushil);

        authorRepository.saveAndFlush(sushil);
        bookRepository.saveAndFlush(jProgramming);


        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("JEE without EJB", "654321", "Wox");
        rod.getBooks().add(noEJB);

        authorRepository.saveAndFlush(rod);
        bookRepository.saveAndFlush(noEJB);
    }
}
