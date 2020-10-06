package web.application.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import web.application.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
