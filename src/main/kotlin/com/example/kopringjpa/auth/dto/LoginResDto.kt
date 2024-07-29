package com.example.kopringjpa.auth.dto

import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.http.HttpStatus

data class LoginResDto(
    @Schema(description = "응답 메시지", example = "로그인 성공")
    val message: String,
    @Schema(description = "JWT 토큰", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
    val token: String? = null, // JWT 토큰이나 기타 인증 정보를 포함'
    @Schema(description = "HTTP 상태 코드", example = "OK")
    val status: HttpStatus
)