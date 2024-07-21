package com.example.kopringjpa.dto

import jakarta.validation.constraints.NotEmpty

data class MemberReqDto(
    @NotEmpty val name: String,
    @NotEmpty val userId: String,
    @NotEmpty val password: String
)