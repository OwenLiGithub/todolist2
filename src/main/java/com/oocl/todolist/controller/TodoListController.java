package com.oocl.todolist.controller;

import com.oocl.todolist.entities.TodoList;
import com.oocl.todolist.exceptions.SameNameException;
import com.oocl.todolist.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todoLists")
@CrossOrigin
public class TodoListController {
    @Autowired
    private TodoListService todoListService;

    @PostMapping
    public ResponseEntity addTodoList(@RequestBody TodoList todoList) throws SameNameException {
        TodoList todoList1 = todoListService.addTodoList(todoList);
        return ResponseEntity.status(HttpStatus.CREATED).body(todoList1);
    }

    @GetMapping
    public ResponseEntity getAllTodoList(){
        return ResponseEntity.ok().body(todoListService.getAllTodoList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTodoList(@PathVariable Integer id){
        todoListService.deleteTodoListById(id);
        return ResponseEntity.ok().body("删除成功");
    }
    @PutMapping
    public ResponseEntity updateTodoList(@RequestBody TodoList todoList){
        todoListService.updateTodoList(todoList);
        return ResponseEntity.ok().body("修改成功");
    }
}
