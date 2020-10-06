package web.application.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import web.application.spring5webapp.model.Author;
import web.application.spring5webapp.model.Book;
import web.application.spring5webapp.model.Publisher;
import web.application.spring5webapp.repositories.AuthorRepository;
import web.application.spring5webapp.repositories.BookRepository;
import web.application.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("Zysk I S-KA");
        publisher.setCity("Poznan");
        publisher.setState("Wielkopolskie");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "111");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author martin = new Author("Martin", "G.G");
        Book game = new Book("Game of Thrones", "222");
        martin.getBooks().add(game);
        game.getAuthors().add(martin);

        game.setPublisher(publisher);
        publisher.getBooks().add(game);

        authorRepository.save(martin);
        bookRepository.save(game);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
        
    }
}
