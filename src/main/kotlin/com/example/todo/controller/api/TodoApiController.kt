package com.example.todo.controller.api

import com.example.todo.domain.dto.TodoDto
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
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
class TodoApiController {

    @GetMapping(path = [""])
    fun read(@RequestParam(required = false) id : Long){

    }

    @PostMapping(path = [""])
    fun create(@Valid @RequestBody todoDto: TodoDto){

    }

    @PutMapping(path = [""])
    fun update(@Valid @RequestBody todoDto: TodoDto){

    }

    @DeleteMapping(path = ["/{id}"])
    fun delete(@PathVariable id:Long){

    }
}