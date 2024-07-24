package com.example.kopringjpa.board.controller

import com.example.kopringjpa.board.dto.BoardReqDto
import com.example.kopringjpa.board.dto.BoardResDto
import com.example.kopringjpa.board.service.BoardService
import com.example.kopringjpa.member.service.MemberService
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/board")
class BoardController(val boardService: BoardService) {

    private val LOG = LoggerFactory.getLogger(MemberService::class.java)

    @PostMapping
    fun writeBoard(@RequestBody @Valid boardDto: BoardReqDto, @AuthenticationPrincipal user: UserDetails): BoardResDto {
        return try {
            LOG.info("boardDto = $boardDto")
            boardService.writeBoard(boardDto,user.username)
            BoardResDto(message = "OK", status = HttpStatus.OK)
        } catch (e: Exception) {
            BoardResDto(message = "${e.message}", status = HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping("/{boardId}")
    fun updateBoard(
        @PathVariable boardId: Long,
        @RequestBody @Valid boardDto: BoardReqDto,
        @AuthenticationPrincipal user: UserDetails
    ): BoardResDto {
        val userId = user.username // 현재 사용자 ID
        return try {
            LOG.info("Updating board with id = $boardId, boardDto = $boardDto")
            boardService.updateBoard(boardId, userId, boardDto)
            BoardResDto(message = "Board updated successfully", status = HttpStatus.OK)
        } catch (e: Exception) {
            BoardResDto(message = "${e.message}", status = HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{boardId}")
    fun deleteBoard(@PathVariable boardId: Long, @AuthenticationPrincipal user: UserDetails): BoardResDto {
        val userId = user.username // 현재 사용자 ID
        return try {
            LOG.info("Deleting board with id = $boardId")
            boardService.deleteBoard(boardId, userId)
            BoardResDto(message = "Board deleted successfully", status = HttpStatus.OK)
        } catch (e: Exception) {
            BoardResDto(message = "${e.message}", status = HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}