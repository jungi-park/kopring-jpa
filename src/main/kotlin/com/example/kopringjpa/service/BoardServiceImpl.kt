package com.example.kopringjpa.service

import com.example.kopringjpa.domain.Board
import com.example.kopringjpa.dto.BoardReqDto
import com.example.kopringjpa.repository.BoardRepository
import org.springframework.stereotype.Service

@Service
class BoardServiceImpl(val boardRepository: BoardRepository, val memberService: MemberService) : BoardService {
    override fun writeBoard(boardDto: BoardReqDto) {
        val member = memberService.findMemberById(1) // 멤버 정보 가져오기
        val board = member?.let { Board(title = boardDto.title, contents = boardDto.contents, member = it) }
            ?: throw IllegalArgumentException("Member not found")
        boardRepository.save(board)
    }
}