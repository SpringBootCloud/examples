package net.boddin.clouddemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class ContactController {
    private final ContactRepository repository;

    @Autowired
    public ContactController(ContactRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("contacts")
    public Collection<Contact> list() {
        final List<Contact> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    @RequestMapping("contacts/{id}")
    public Contact byId(@PathVariable Long id){
        return repository.findOne(id);
    }

    @PostMapping("contacts/{id}/firstname")
    public Contact setFirstnameForId(@PathVariable Long id, @RequestBody Contact contact){
        repository.setFirstnameForId(contact.getFirstName(), id);
        return repository.findOne(id);
    }

    @RequestMapping("contacts/query")
    public Collection<Contact> byLastName(@RequestParam("lastName") String lastName){
        return repository.findByLastNameLikeIgnoreCase(String.format("%%%s%%",lastName));
    }
}
