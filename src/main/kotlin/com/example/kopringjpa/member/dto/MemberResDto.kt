package com.example.kopringjpa.member.dto

import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.http.HttpStatus

data class MemberResDto(
    @Schema(description = "응답 메시지", example = "OK")
    val message: String,
    @Schema(description = "HTTP 상태 코드", example = "OK")
    val status: HttpStatus
)