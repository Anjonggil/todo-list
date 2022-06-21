package com.example.todo.domain.entity

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.persistence.*

@Entity
class Todo(
    id: Long? = null,
    title: String? = null,
    description: String? = null,
    schedule: LocalDateTime? = null,
    createdAt: LocalDateTime? = null,
    updatedAt: LocalDateTime? = null
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    var id: Long? = id
        private set

    var title: String? = title
        private set

    var description: String? = description
        private set

    var schedule: LocalDateTime? = schedule
        private set

    @Column(name = "created_at")
    var createdAt: LocalDateTime? = createdAt
        private set

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime? = updatedAt
        private set

    fun changeMemo(title: String?, description: String?, schedule: String?) {
        this.title = title
        this.description = description
        this.schedule = LocalDateTime.parse(schedule, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        this.updatedAt = LocalDateTime.now()
    }
}