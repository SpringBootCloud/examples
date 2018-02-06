package net.boddin.clouddemo;

import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("demo")
public class DemoController {

    @RequestMapping(value = "/one", method = RequestMethod.GET)
    public @ResponseBody
    ExampleDto getOne() {
        return new ExampleDto("hello");
    }

    @RequestMapping(value = {"/multi", "/multimap"}, method = RequestMethod.GET)
    public @ResponseBody
    ExampleDto getOneMulti() {
        return new ExampleDto("multimapping");
    }

    @RequestMapping(value = "/all")
    public @ResponseBody
    ExampleDto getAll() {
        return new ExampleDto("all");
    }

    @RequestMapping(value = "/headers", method = RequestMethod.GET, headers = {"x-custom=one"})
    public @ResponseBody
    ExampleDto getHeaders() {
        return new ExampleDto("headers");
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET, produces = {"application/json"})
    public @ResponseBody
    ExampleDto getJson() {
        return new ExampleDto("json");
    }

    @RequestMapping(value = "/xml", method = RequestMethod.GET, produces = {"application/xml"})
    public @ResponseBody
    ExampleDto getXml() {
        return new ExampleDto("xml");
    }

    @RequestMapping(value = "/jsonxml", method = RequestMethod.GET, produces = {"application/xml", "application/json"})
    public @ResponseBody
    ExampleDto getJsonXml() {
        return new ExampleDto("json-xml");
    }

    @RequestMapping(value = "/consume", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    ExampleDto postConsume(@RequestBody ExampleDto dto) {
        return new ExampleDto("hello " + dto.getName());
    }

    @RequestMapping(value = "/consume/default", method = RequestMethod.POST)
    public @ResponseBody
    ExampleDto postConsumeDefault(@RequestBody ExampleDto dto) {
        return new ExampleDto("hello " + dto.getName());
    }

}
