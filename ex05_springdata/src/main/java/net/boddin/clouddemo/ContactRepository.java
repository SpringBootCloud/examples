package net.boddin.clouddemo;

import com.sun.javaws.jnl.ShortcutDesc;
import net.boddin.clouddemo.entity.Contact;
import net.boddin.clouddemo.entity.ShortContact;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Transactional
public interface ContactRepository extends CrudRepository<Contact, Long> {

    Collection<Contact> findByLastNameLikeIgnoreCase(String lastName);
    long countByLastNameLikeIgnoreCase(String lastName);

    Collection<Contact> findCustom(String value);

    @Modifying
    @Query("update Contact c set c.firstName = ?1 where c.id = ?2")
    int setFirstnameForId(String firstName, Long id);

    ShortContact findById(Long id);
}
