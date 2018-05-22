package com.troytan.ymcake.dto;

import java.util.List;

public class AreaDto {

    private Long          id;
    private String        name;
    private List<AreaDto> childs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AreaDto> getChilds() {
        return childs;
    }

    public void setChilds(List<AreaDto> childs) {
        this.childs = childs;
    }

}
