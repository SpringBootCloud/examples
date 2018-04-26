package net.boddin.clouddemo;

import net.boddin.clouddemo.entity.Contact;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;

public class ContactServiceUnitTests {

    private ContactService contactService;

    private ContactRepository contactRepositoryMock;

    @Before
    public void setup() {
        contactRepositoryMock = Mockito.mock(ContactRepository.class);
        contactService = new ContactService(contactRepositoryMock);
    }

    @Test
    public void createContactTest() {
        Mockito.doAnswer(AdditionalAnswers.returnsFirstArg()).when(contactRepositoryMock).save(Mockito.any(Contact.class));

        Contact c = contactService.createContact("first", "second");
        Assertions.assertThat(c).isNotNull();
        Assertions.assertThat(c.getFirstName()).isEqualTo("first");
        Assertions.assertThat(c.getLastName()).isEqualTo("second");
    }
}
