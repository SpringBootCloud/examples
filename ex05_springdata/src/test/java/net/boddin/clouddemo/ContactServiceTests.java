package net.boddin.clouddemo;

import net.boddin.clouddemo.entity.Contact;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;

public class ContactServiceTests {

    private ContactRepository contactRepositoryMock;

    private ContactService contactService;

    @Before
    public void setUp() {
        contactRepositoryMock = Mockito.mock(ContactRepository.class);
        contactService = new ContactService(contactRepositoryMock);
    }

    @Test
    public void createContactTest(){
        Mockito.doAnswer(AdditionalAnswers.returnsFirstArg())
                .when(contactRepositoryMock).save(Mockito.any(Contact.class));
        Contact c = contactService.createContact("first", "second");
        Assertions.assertThat(c.getFirstName()).isEqualTo("first");
        Assertions.assertThat(c.getLastName()).isEqualTo("second");
    }
}
