package net.boddin.clouddemo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Transactional
public interface ContactRepository extends CrudRepository<Contact, Long> {
    Collection<Contact> findByLastNameLikeIgnoreCase(String lastName);
    long countByLastNameLikeIgnoreCase(String lastName);


    @Modifying
    @Query("update Contact c set c.firstName = ?1 where c.id = ?2")
    int setFirstnameForId(String firstName, Long id);

}
