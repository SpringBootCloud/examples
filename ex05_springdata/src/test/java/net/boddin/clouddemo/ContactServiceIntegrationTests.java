package net.boddin.clouddemo;

import net.boddin.clouddemo.entity.Contact;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ContactServiceIntegrationTests {

    @Autowired
    private ContactService contactService;

    @Autowired
    private ContactRepository contactRepository;

    @TestConfiguration
    static class TestContextConfiguration {
        @MockBean
        private ContactRepository contactRepositoryMock;

        @Bean
        public ContactService contactService() {
            return new ContactService(contactRepositoryMock);
        }
    }

    @Test
    public void createContactTest() {
        Mockito.doAnswer(AdditionalAnswers.returnsFirstArg())
                .when(contactRepository).save(Mockito.any(Contact.class));
        Contact c = contactService.createContact("first", "second");
        Assertions.assertThat(c.getFirstName()).isEqualTo("first");
        Assertions.assertThat(c.getLastName()).isEqualTo("second");
    }
}
