package com.example.todo.service

import com.example.todo.domain.dto.TodoDto
import com.example.todo.domain.dto.toDto
import com.example.todo.domain.dto.toEntity
import com.example.todo.domain.entity.Todo
import com.example.todo.repository.TodoRepository
import org.springframework.stereotype.Service

@Service
class TodoService(
    val todoRepository: TodoRepository
) {

    fun create(todoDto: TodoDto): Todo {
        return todoDto.let {
            TodoDto().toEntity(it)
        }.let {
            todoRepository.save(it)
        }
    }

    fun read(id: Long): TodoDto? {
        return todoRepository.findById(id).orElseThrow().let {
            TodoDto().toDto(it)
        }
    }

    fun readAll(): MutableList<TodoDto> {
        return todoRepository
            .findAll()
            .map {
                TodoDto().toDto(it)
            }.toMutableList()
    }

    fun update(todoDto: TodoDto) {
        todoDto.let {
            it.id?.let { it1 ->
                todoRepository.findById(it1).orElseThrow()
            }
        }?.changeMemo(todoDto.title, todoDto.description, todoDto.schedule)
    }

    fun delete(id: Long) {
        todoRepository.findById(id)
            .orElseThrow().let {
                todoRepository.delete(it)
            }
    }
}