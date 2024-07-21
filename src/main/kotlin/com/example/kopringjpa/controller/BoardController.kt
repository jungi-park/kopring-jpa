package com.example.kopringjpa.controller

import com.example.kopringjpa.dto.BoardReqDto
import com.example.kopringjpa.dto.BoardResDto
import com.example.kopringjpa.service.BoardService
import com.example.kopringjpa.service.MemberService
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/board")
class BoardController(val boardService: BoardService) {

    private val LOG = LoggerFactory.getLogger(MemberService::class.java)

    @PostMapping
    fun writeBoard(@RequestBody @Valid boardDto: BoardReqDto): BoardResDto {
        return try {
            LOG.info("boardDto = $boardDto")
            boardService.writeBoard(boardDto)
            BoardResDto(message = "OK", status = HttpStatus.OK)
        } catch (e: Exception) {
            BoardResDto(message = "${e.message}", status = HttpStatus.INTERNAL_SERVER_ERROR)
        }

    }
}