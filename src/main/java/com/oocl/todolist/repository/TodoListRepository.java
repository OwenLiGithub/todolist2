package com.oocl.todolist.repository;

import com.oocl.todolist.entities.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface TodoListRepository extends JpaRepository<TodoList,Integer> {
    @Query(value = "update todo_list set value =:#{#todoList.value},is_Checked =:#{#todoList.isChecked} where id =:#{#todoList.id}",nativeQuery = true)
    @Modifying
    @Transactional
    void updateTodoList(@Param("todoList") TodoList todoList);

    List<TodoList> findByValue(String value);
}
