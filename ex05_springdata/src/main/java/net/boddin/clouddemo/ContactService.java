package net.boddin.clouddemo;

import net.boddin.clouddemo.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    private ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact createContact(String name, String name2){
        Contact c = new Contact(name, name2);
        return contactRepository.save(c);
    }
}
