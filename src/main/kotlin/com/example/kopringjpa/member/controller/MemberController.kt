package com.example.kopringjpa.member.controller

import com.example.kopringjpa.member.dto.MemberReqDto
import com.example.kopringjpa.member.dto.MemberResDto
import com.example.kopringjpa.member.service.MemberService
import io.swagger.v3.oas.annotations.Operation
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
@RequestMapping("/api/v1/member")
@Tag(name = "Member", description = "회원 관련 엔드포인트")
class MemberController(private val memberService: MemberService) {

    private val LOG = LoggerFactory.getLogger(MemberService::class.java)

    @PostMapping
    @Operation(summary = "회원 가입", description = "새로운 회원을 등록합니다.")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "회원 가입 성공"),
            ApiResponse(responseCode = "500", description = "서버 오류")
        ]
    )
    fun createMember(@RequestBody @Valid memberDto: MemberReqDto): MemberResDto {
        return try {
            LOG.info("memberDto $memberDto")
            memberService.createMember(memberDto)
            MemberResDto(message = "OK", status = HttpStatus.OK)
        } catch (e: Exception) {
            MemberResDto(message = "${e.message}", status = HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

}