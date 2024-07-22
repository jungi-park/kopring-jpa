package com.example.kopringjpa.controller

import com.example.kopringjpa.dto.LoginReqDto
import com.example.kopringjpa.dto.LoginResDto
import com.example.kopringjpa.service.AuthService
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class AuthController(private val authService: AuthService) {

    private val LOG = LoggerFactory.getLogger(AuthController::class.java)

    @PostMapping("/login")
    fun login(@RequestBody @Valid loginDto: LoginReqDto): LoginResDto {
        return try {
            LOG.info("loginDto $loginDto")
            val token = authService.login(loginDto)
            LoginResDto(message = "Login successful", token = token, status = HttpStatus.OK)
        } catch (e: Exception) {
            LoginResDto(message = "${e.message}", status = HttpStatus.UNAUTHORIZED)
        }
    }
}