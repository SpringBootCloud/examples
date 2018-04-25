package net.boddin.clouddemo;

import net.boddin.clouddemo.entity.Contact;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ContactRepositoryIntegrationTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ContactRepository contactRepository;

    @Test
    public void testFindCustom(){
        Contact c = new Contact("first", "second");
        entityManager.persistAndFlush(c);
        Collection<Contact> list = contactRepository.findCustom("first");
        Assertions.assertThat(list).isNotEmpty();
        Collection<Contact> list2 = contactRepository.findCustom("second");
        Assertions.assertThat(list2).isNotEmpty();
        Collection<Contact> list3 = contactRepository.findCustom("nein");
        Assertions.assertThat(list3).isEmpty();
    }
}
