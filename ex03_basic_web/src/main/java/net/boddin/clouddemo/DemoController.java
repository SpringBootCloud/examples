package net.boddin.clouddemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("demo")
public class DemoController {

    @RequestMapping("one")
    public Object getDemoObject(){
        return "hello";
    }
}
