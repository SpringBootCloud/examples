package net.boddin.clouddemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping("path")
public class DemoPathController {

    @RequestMapping("/simple/{name}")
    public @ResponseBody
    ExampleDto getPath(@PathVariable() String name) {
        return new ExampleDto(name);
    }

    @RequestMapping("/named/{name}/{surname}")
    public @ResponseBody
    ExampleDto getPathNamed(@PathVariable("surname") String secondName, @PathVariable("name") String firstName) {
        return new ExampleDto(String.format("%s %s", firstName, secondName));
    }

    @RequestMapping({"/optional/{name}/{surname}", "/optional/{name}"})
    public @ResponseBody
    ExampleDto getPathOptional(@PathVariable String name, @PathVariable(required = false) String surname) {
        return new ExampleDto(String.format("optional %s %s", name, surname));
    }

    @RequestMapping("/regex/{id:[\\d]+}")
    public @ResponseBody
    ExampleDto getPath(@PathVariable int id) {
        return new ExampleDto("hello " + id);
    }
}
