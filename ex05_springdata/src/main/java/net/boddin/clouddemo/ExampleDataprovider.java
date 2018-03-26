package net.boddin.clouddemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ExampleDataprovider implements ApplicationRunner {

    private final ContactRepository repository;

    @Autowired
    public ExampleDataprovider(ContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) {
        repository.save(new Contact("John", "Wick"));
        repository.save(new Contact("Mister", "Miagi"));
        repository.save(new Contact("Tyler", "Durden"));
        repository.save(new Contact("Denny", "Crane"));
        repository.save(new Contact("Sheldon", "Cooper"));
    }
}
