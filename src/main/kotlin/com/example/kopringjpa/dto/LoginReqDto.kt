package com.example.kopringjpa.dto

import jakarta.validation.constraints.NotBlank

data class LoginReqDto(@NotBlank val userId: String, @NotBlank val password: String)