package net.boddin.clouddemo.controller;

import net.boddin.clouddemo.dto.ExampleDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("fallback")
public class FallbackController {

    @RequestMapping("/*")
    public @ResponseBody
    ExampleDto getFallback() {
        return new ExampleDto("fallback single");
    }

    @RequestMapping("/multi/**")
    public @ResponseBody
    ExampleDto getFallbackMulti(WebRequest request) {
        return new ExampleDto(String.format("fallback multi (%s)", request));
    }
}
