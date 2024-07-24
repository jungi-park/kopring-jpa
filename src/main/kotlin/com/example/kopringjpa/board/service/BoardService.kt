package com.example.kopringjpa.board.service

import com.example.kopringjpa.board.dto.BoardReqDto

interface BoardService {
    fun writeBoard(boardDto: BoardReqDto, userId: String)
    fun deleteBoard(boardId: Long, userId: String)
    fun updateBoard(boardId: Long, userId: String, boardDto: BoardReqDto)
}