package com.oocl.todolist.service;

import com.oocl.todolist.entities.TodoList;
import com.oocl.todolist.exceptions.SameNameException;
import com.oocl.todolist.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListService {
    @Autowired
    private TodoListRepository todoListRepository;

    public TodoList addTodoList(TodoList todoList) throws SameNameException {
        List<TodoList> todoLists = todoListRepository.findByValue(todoList.getValue());
        if(todoLists.size()>0){
            throw new SameNameException("名字已存在");
        }
        return todoListRepository.save(todoList);
    }
    public List<TodoList> getAllTodoList(){
        return todoListRepository.findAll();
    }
    public void updateTodoList(TodoList todoList){
        todoListRepository.updateTodoList(todoList);
    }

    public void deleteTodoListById(Integer id){
        todoListRepository.deleteById(id);
    }
}
