package com.example.kopringjpa.auth.controller

import com.example.kopringjpa.auth.dto.LoginReqDto
import com.example.kopringjpa.auth.dto.LoginResDto
import com.example.kopringjpa.auth.service.AuthService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Auth", description = "인증 관련 엔드포인트")
class AuthController(private val authService: AuthService) {

    private val LOG = LoggerFactory.getLogger(AuthController::class.java)

    @PostMapping("/login")
    @Operation(summary = "사용자 로그인", description = "사용자를 로그인하고 JWT 토큰을 반환합니다.")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "로그인 성공"),
            ApiResponse(responseCode = "401", description = "권한 없음 - 잘못된 자격 증명")
        ]
    )
    fun login(
        @RequestBody @Valid loginDto: LoginReqDto
    ): LoginResDto {
        return try {
            LOG.info("loginDto $loginDto")
            val token = authService.login(loginDto)
            LoginResDto(message = "Login successful", token = token, status = HttpStatus.OK)
        } catch (e: Exception) {
            LoginResDto(message = "${e.message}", status = HttpStatus.UNAUTHORIZED)
        }
    }
}