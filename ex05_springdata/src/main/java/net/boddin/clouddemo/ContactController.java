package net.boddin.clouddemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("contacts/query")
    public Collection<Contact> byLastName(@RequestParam("lastName") String lastName){
        return repository.findByLastNameLikeIgnoreCase(String.format("%%%s%%",lastName));
    }
}
