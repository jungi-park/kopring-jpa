package com.example.kopringjpa.board.controller

import com.example.kopringjpa.board.dto.BoardReqDto
import com.example.kopringjpa.board.dto.BoardResDto
import com.example.kopringjpa.board.service.BoardService
import com.example.kopringjpa.member.service.MemberService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/board")
@Tag(name = "Board", description = "게시판 관련 엔드포인트")
class BoardController(val boardService: BoardService) {

    private val LOG = LoggerFactory.getLogger(MemberService::class.java)

    @PostMapping
    @Operation(summary = "게시판 글 작성", description = "새 게시글을 작성합니다.")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "게시글 작성 성공"),
            ApiResponse(responseCode = "500", description = "서버 오류")
        ]
    )
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
    @Operation(summary = "게시판 글 수정", description = "게시글을 수정합니다.")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "게시글 수정 성공"),
            ApiResponse(responseCode = "500", description = "서버 오류")
        ]
    )
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
    @Operation(summary = "게시판 글 삭제", description = "게시글을 삭제합니다.")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "게시글 삭제 성공"),
            ApiResponse(responseCode = "500", description = "서버 오류")
        ]
    )
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