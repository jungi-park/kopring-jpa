package com.example.kopringjpa.dto

import org.springframework.http.HttpStatus

data class LoginResDto(
    val message: String,
    val token: String? = null, // JWT 토큰이나 기타 인증 정보를 포함
    val status: HttpStatus
)