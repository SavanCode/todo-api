package com.example.todoapi.controller;

import com.example.todoapi.dto.TodoDTO;
import com.example.todoapi.service.TodoService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // 允许跨域，实际项目中要配置具体域名
public class TodoController {
    
    private final TodoService todoService;
    
    // 获取所有TODO
    @GetMapping
    public ResponseEntity<List<TodoDTO>> getAllTodos() {
        return ResponseEntity.ok(todoService.getAllTodos());
    }
    
    // 根据ID获取TODO
    @GetMapping("/{id}")
    public ResponseEntity<TodoDTO> getTodoById(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.getTodoById(id));
    }
    
    // 创建TODO
    @PostMapping
    public ResponseEntity<TodoDTO> createTodo(@Valid @RequestBody TodoDTO todoDTO) {
        TodoDTO createdTodo = todoService.createTodo(todoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTodo);
    }
    
    // 更新TODO
    @PutMapping("/{id}")
    public ResponseEntity<TodoDTO> updateTodo(@PathVariable Long id, 
                                             @Valid @RequestBody TodoDTO todoDTO) {
        TodoDTO updatedTodo = todoService.updateTodo(id, todoDTO);
        return ResponseEntity.ok(updatedTodo);
    }
    
    // 删除TODO
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }
    
    // 根据完成状态筛选
    @GetMapping("/status")
    public ResponseEntity<List<TodoDTO>> getTodosByStatus(@RequestParam Boolean completed) {
        return ResponseEntity.ok(todoService.getTodosByCompleted(completed));
    }
}