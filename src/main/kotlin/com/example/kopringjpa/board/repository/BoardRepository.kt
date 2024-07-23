package com.example.kopringjpa.board.repository

import com.example.kopringjpa.board.domain.Board
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BoardRepository : JpaRepository<Board,Long> {
}