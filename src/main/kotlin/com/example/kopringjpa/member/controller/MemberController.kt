package com.example.kopringjpa.member.controller

import com.example.kopringjpa.member.dto.MemberReqDto
import com.example.kopringjpa.member.dto.MemberResDto
import com.example.kopringjpa.member.service.MemberService
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/member")
class MemberController(private val memberService: MemberService) {

    private val LOG = LoggerFactory.getLogger(MemberService::class.java)

    @PostMapping
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