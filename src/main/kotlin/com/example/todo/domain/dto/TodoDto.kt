package com.example.todo.domain.dto

import com.example.mvc.validator.StringFormatDateTime
import java.time.LocalDateTime
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
    val updatedAt:LocalDateTime?=null
)