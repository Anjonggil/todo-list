package com.example.todo.controller.api

import com.example.todo.domain.dto.TodoDto
import com.example.todo.service.TodoService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/todo")
class TodoApiController (
    val todoService: TodoService
        ){

    @GetMapping(path = [""])
    fun read(@RequestParam(required = true) id : Long) : ResponseEntity<TodoDto>{
        return todoService.read(id).let {
             ResponseEntity.ok(it)
        }
    }

    @GetMapping(path = ["/all"])
    fun readAll() : ResponseEntity<Any>{
        return todoService.readAll().let {
            ResponseEntity.ok(it)
        }
    }

    @PostMapping(path = [""])
    fun create(@Valid @RequestBody todoDto: TodoDto){
        return todoService.create(todoDto).let {
            ResponseEntity.status(HttpStatus.CREATED).body(todoDto)
        }
    }

    @PatchMapping(path = [""])
    fun update(@Valid @RequestBody todoDto: TodoDto){
        todoService.update(todoDto)
    }

    @DeleteMapping(path = ["/{id}"])
    fun delete(@PathVariable id:Long){
        todoService.delete(id)
    }
}