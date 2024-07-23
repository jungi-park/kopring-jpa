package com.example.kopringjpa.board.dto

import org.springframework.http.HttpStatus

class BoardResDto(
    val message: String,
    val status: HttpStatus
)
