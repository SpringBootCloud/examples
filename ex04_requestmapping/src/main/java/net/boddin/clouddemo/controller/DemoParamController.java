package net.boddin.clouddemo.controller;

import net.boddin.clouddemo.dto.ExampleDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping("param")
public class DemoParamController {

    @RequestMapping(value = "/optional")
    public @ResponseBody
    ExampleDto getWithParams(@RequestParam("name") Optional<String> name) {
        return new ExampleDto(String.format("param: %s", name));
    }

    @RequestMapping(value = "/required", params = {"name"})
    public @ResponseBody
    ExampleDto getWithRequiredParams(@RequestParam("name") String name) {
        return new ExampleDto(String.format("param: %s", name));
    }
}
