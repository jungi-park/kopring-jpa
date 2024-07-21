package com.example.kopringjpa.dto

import org.springframework.http.HttpStatus

class BoardResDto(
    val message: String,
    val status: HttpStatus
)
