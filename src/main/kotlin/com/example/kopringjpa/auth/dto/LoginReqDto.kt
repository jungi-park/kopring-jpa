package com.example.kopringjpa.auth.dto

import jakarta.validation.constraints.NotBlank

data class LoginReqDto(@NotBlank val userId: String, @NotBlank val password: String)