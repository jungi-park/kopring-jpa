package com.example.kopringjpa.board.dto

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotEmpty

data class BoardReqDto(
    @NotEmpty @Schema(description = "게시글 제목", required = true, example = "제목을 여기에 입력하세요") val title: String,
    @NotEmpty @Schema(description = "게시글 내용", required = true, example = "내용을 여기에 입력하세요") val contents: String,
)