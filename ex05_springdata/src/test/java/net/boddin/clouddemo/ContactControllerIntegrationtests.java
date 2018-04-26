package net.boddin.clouddemo;

import net.boddin.clouddemo.entity.Contact;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(ContactController.class)
public class ContactControllerIntegrationtests {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ContactRepository contactRepository;

    @Test
    public void testGetById() throws Exception {

        Contact c = new Contact("first", "second");
        Mockito.when(contactRepository.findOne(Mockito.anyLong())).thenReturn(c);

        mvc.perform(MockMvcRequestBuilders.get("/contacts/2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", Matchers.is("first")));
    }
}
