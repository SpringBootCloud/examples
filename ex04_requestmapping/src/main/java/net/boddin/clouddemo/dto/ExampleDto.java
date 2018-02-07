package net.boddin.clouddemo.dto;

public class ExampleDto {
    private String name;

    public ExampleDto() {
    }

    public ExampleDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
