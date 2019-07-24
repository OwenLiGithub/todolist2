package com.oocl.todolist.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TodoList {
    @Id
    private Integer id;
    private String value;
    private boolean isChecked;

    public TodoList(int id, String value, boolean isChecked) {
        this.id = id;
        this.value = value;
        this.isChecked = isChecked;
    }

    public TodoList() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean getIsChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
