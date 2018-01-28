package net.boddin.boot;

import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{
    @Override
    public String getMessage() {
        return "Hello Spring Boot";
    }
}
