package com.example.kopringjpa.member.dto

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotEmpty

data class MemberReqDto(
    @Schema(description = "회원 이름", required = true, example = "홍길동")
    @NotEmpty val name: String,
    @Schema(description = "회원 사용자 ID", required = true, example = "user123")
    @NotEmpty val userId: String,
    @Schema(description = "회원 비밀번호", required = true, example = "password123")
    @NotEmpty val password: String
)