package com.example.kopringjpa.common.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/health")
@Tag(name = "HealthCheck", description = "서버 상태 확인 엔드포인트")
class HealthCheckController {

    @GetMapping
    @Operation(summary = "서버 상태 확인", description = "서버가 정상인지 확인합니다.")
    fun healthCheck(): String {
        return "OK"
    }
}