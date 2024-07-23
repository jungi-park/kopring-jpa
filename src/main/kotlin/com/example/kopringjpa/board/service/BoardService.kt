package com.example.kopringjpa.board.service

import com.example.kopringjpa.board.dto.BoardReqDto

interface BoardService {
    fun writeBoard(boardDto: BoardReqDto)
}