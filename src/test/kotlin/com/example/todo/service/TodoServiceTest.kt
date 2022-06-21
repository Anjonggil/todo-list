package com.example.todo.service

import com.example.todo.domain.dto.TodoDto
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

@SpringBootTest
internal class TodoServiceTest{

    @Autowired
    lateinit var todoService: TodoService

    @Test
    fun createTest(){
        val todoDto = TodoDto().apply {
            this.title = "test"
            this.description = "test description"
            this.schedule = "2022-06-21 14:35:00"
            this.createdAt = LocalDateTime.now()
            this.updatedAt = LocalDateTime.now()
        }
        val todo = todoService.create(todoDto)

        Assertions.assertThat(todo.id).isEqualTo(1)
        Assertions.assertThat(todo.title).isEqualTo("test")
        Assertions.assertThat(todo.description).isEqualTo("test description")
    }
}