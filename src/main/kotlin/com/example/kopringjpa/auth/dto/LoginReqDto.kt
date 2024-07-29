package com.example.kopringjpa.auth.dto

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank

data class LoginReqDto(
    @NotBlank @Schema(description = "사용자 ID", required = true) val userId: String,
    @NotBlank @Schema(description = "사용자 비밀번호", required = true) val password: String
)