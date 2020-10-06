package web.application.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import web.application.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
