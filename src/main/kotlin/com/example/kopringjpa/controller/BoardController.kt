package com.example.kopringjpa.controller

import com.example.kopringjpa.dto.BoardReqDTO
import com.example.kopringjpa.service.BoardService
import com.example.kopringjpa.service.MemberService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/board")
class BoardController(val boardService: BoardService) {

    private val LOG = LoggerFactory.getLogger(MemberService::class.java)

    @PostMapping
    fun writeBoard(@RequestBody boardDto: BoardReqDTO) {
        LOG.info("boardDto = $boardDto")
        boardService.writeBoard(boardDto)
    }
}