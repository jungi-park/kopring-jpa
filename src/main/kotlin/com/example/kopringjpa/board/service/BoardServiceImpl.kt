package com.example.kopringjpa.board.service

import com.example.kopringjpa.board.domain.Board
import com.example.kopringjpa.member.service.MemberService
import com.example.kopringjpa.board.dto.BoardReqDto
import com.example.kopringjpa.board.repository.BoardRepository
import org.springframework.stereotype.Service

@Service
class BoardServiceImpl(val boardRepository: BoardRepository, val memberService: MemberService) : BoardService {
    override fun writeBoard(boardDto: BoardReqDto, userId: String) {
        val member = memberService.findMemberByUserId(userId) // 멤버 정보 가져오기
        val board = member?.let { Board(title = boardDto.title, contents = boardDto.contents, member = it) }
            ?: throw IllegalArgumentException("Member not found")
        boardRepository.save(board)
    }

    override fun deleteBoard(boardId: Long, userId: String) {
        val board = boardRepository.findById(boardId).orElseThrow {
            Exception("Board not found")
        }
        // 작성자 확인
        if (board.member.id.toString() != userId) {
            throw Exception("You do not have permission to delete this board")
        }
        boardRepository.delete(board)
    }

    override fun updateBoard(boardId: Long, userId: String, boardDto: BoardReqDto) {
        val board = boardRepository.findById(boardId).orElseThrow {
            Exception("Board not found")
        }
        // 작성자 확인
        if (board.member.id.toString() != userId) {
            throw Exception("You do not have permission to delete this board")
        }
        board.title = boardDto.title
        board.contents = boardDto.contents
        boardRepository.save(board)
    }

}