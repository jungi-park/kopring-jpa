package com.example.kopringjpa.dto

import jakarta.validation.constraints.NotEmpty

data class BoardReqDTO(
    @NotEmpty val title: String,
    @NotEmpty val contents: String,
)