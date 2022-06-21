package com.example.todo.domain.dto

import com.example.todo.domain.entity.Todo
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.NotBlank

data class TodoDto(
    var id:Long? = null,

    @field:NotBlank
    var title:String? = null,

    var description:String? = null,

    @field:NotBlank
    var schedule:String?=null,

//    @field:StringFormatDateTime
    var createdAt:LocalDateTime?=null,

//    @field:StringFormatDateTime
    var updatedAt:LocalDateTime?=null
)

fun TodoDto.createEntity(): Todo{
    return Todo(
        id = this.id,
        title = this.title,
        description = this.description,
        schedule = LocalDateTime.parse(this.schedule,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now()
    )
}

fun TodoDto.toEntity(): Todo{
    return Todo(
        id = this.id,
        title = this.title,
        description = this.description,
        schedule = LocalDateTime.parse(this.schedule,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
        createdAt = this.createdAt,
        updatedAt = this.updatedAt
    )
}

fun TodoDto.toDto(todo: Todo) : TodoDto{
    return TodoDto().apply {
        this.id = todo.id
        this.title = todo.title
        this.description = todo.description
        this.schedule = todo.schedule?.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        this.createdAt = todo.createdAt
        this.updatedAt = todo.updatedAt
    }
}

