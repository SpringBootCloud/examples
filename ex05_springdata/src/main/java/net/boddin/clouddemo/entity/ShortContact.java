package net.boddin.clouddemo.entity;

import org.springframework.beans.factory.annotation.Value;

public interface ShortContact {
    @Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();

    String getLastName();
    String getFirstName();
}
