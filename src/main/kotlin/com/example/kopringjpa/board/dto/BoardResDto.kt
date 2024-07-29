package com.example.kopringjpa.board.dto

import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.http.HttpStatus

class BoardResDto(
    @Schema(description = "응답 메시지", example = "게시글 삭제 성공")
    val message: String,
    @Schema(description = "HTTP 상태 코드", example = "OK")
    val status: HttpStatus
)
