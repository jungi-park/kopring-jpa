package com.example.kopringjpa.controller

import com.example.kopringjpa.dto.MemberReqDto
import com.example.kopringjpa.dto.MemberResDto
import com.example.kopringjpa.service.MemberService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/member")
class MemberController(private val memberService: MemberService) {

    private val LOG = LoggerFactory.getLogger(MemberService::class.java)

    @PostMapping
    fun createMember(@RequestBody memberDto: MemberReqDto): MemberResDto {
        return try {
            LOG.info("memberDto $memberDto")
            memberService.createMember(memberDto)
            MemberResDto(message = "OK", status = HttpStatus.OK)
        } catch (e: Exception) {
            MemberResDto(message = "${e.message}", status = HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

}