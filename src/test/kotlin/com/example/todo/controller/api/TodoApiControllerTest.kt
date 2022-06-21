package com.example.todo.controller.api

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MockMvcBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest
@AutoConfigureMockMvc
internal class TodoApiControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun read() {
        mockMvc.perform(
            MockMvcRequestBuilders.get("/api/todo")
        ).andExpect (MockMvcResultMatchers.status().isOk
        ).andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun readAll() {
    }

    @Test
    fun create() {
    }

    @Test
    fun update() {
    }

    @Test
    fun delete() {
    }

    @Test
    fun getTodoService() {
    }
}