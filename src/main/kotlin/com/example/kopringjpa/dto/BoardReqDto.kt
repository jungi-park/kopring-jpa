package com.example.kopringjpa.dto

import jakarta.validation.constraints.NotEmpty

data class BoardReqDto(
    @NotEmpty val title: String,
    @NotEmpty val contents: String,
)