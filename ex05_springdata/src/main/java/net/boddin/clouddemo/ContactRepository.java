package net.boddin.clouddemo;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long> {
    Collection<Contact> findByLastNameLikeIgnoreCase(String lastName);
}
