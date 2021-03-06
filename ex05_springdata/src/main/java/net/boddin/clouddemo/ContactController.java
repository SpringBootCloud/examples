package net.boddin.clouddemo;

import net.boddin.clouddemo.entity.Contact;
import net.boddin.clouddemo.entity.ShortContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    @RequestMapping("contacts/paged")
    public Page<Contact> listPaged() {
        PageRequest request = new PageRequest(0,2, Sort.Direction.ASC, "firstName", "lastName");
        Page<Contact> all = repository.findAll(request);
        return all;
    }

    @RequestMapping("contacts/{id}")
    public Contact byId(@PathVariable Long id){

        return repository.findOne(id);
    }

    @RequestMapping("contacts/{id}/short")
    public ShortContact byIdShort(@PathVariable Long id){
        return repository.findById(id);
    }

    @PostMapping("contacts/{id}/firstname")
    public Contact setFirstnameForId(@PathVariable Long id, @RequestBody Contact contact){
        repository.setFirstnameForId(contact.getFirstName(), id);
        /*
        Contact dbContact = repository.findOne(id);
        dbContact.setFirstName(contact.getFirstName());
        repository.save(dbContact);
         */
        return repository.findOne(id);
    }

    @RequestMapping("contacts/query")
    public Collection<Contact> byLastName(@RequestParam("lastName") String lastName){
        return repository.findByLastNameLikeIgnoreCase(String.format("%%%s%%",lastName));
    }

    @RequestMapping("contacts/query/custom")
    public Collection<Contact> customQuery(@RequestParam("value") String lastName){
        return repository.findCustom(lastName.toLowerCase());
    }
}
