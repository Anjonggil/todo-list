package com.example.todo.domain.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Todo(
    title: String,
    description: String?,
    schedule: LocalDateTime?,
    createdAt: LocalDateTime,
    updatedAt: LocalDateTime?
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    var id: Long? = null
        private set

    var title: String = title
        private set

    var description: String? = description
        private set

    var schedule: LocalDateTime? = schedule
        private set

    @Column(name = "created_at")
    var createdAt: LocalDateTime = createdAt
        private set

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime? = updatedAt
        private set

    fun changeMemo(title: String, description: String, schedule: LocalDateTime) {
        this.title = title
        this.description = description
        this.schedule = schedule
        this.updatedAt = LocalDateTime.now()
    }
}