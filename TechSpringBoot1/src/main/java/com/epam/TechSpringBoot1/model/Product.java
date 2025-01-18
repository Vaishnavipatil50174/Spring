package com.epam.TechSpringBoot1.model;

public class Product {
    private Integer pid;
    private String pname;

    public Product(Integer pid, String pname) {
        this.pid = pid;
        this.pname = pname;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}
