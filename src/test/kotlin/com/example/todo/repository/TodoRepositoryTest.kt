package com.example.todo.repository

import com.example.todo.domain.entity.Todo
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

@SpringBootTest
class TodoRepositoryTest {

    @Autowired
    lateinit var todoRepository: TodoRepository

    @Test
    fun saveTest(){
        val todo = Todo(
            title = "테스트 일정",
            description = "테스트",
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now(),
            schedule = null
        )

        todoRepository.save(todo)

        assertThat(todo.id).isEqualTo(1)
        assertThat(todo.title).isEqualTo("테스트 일정")
    }
}