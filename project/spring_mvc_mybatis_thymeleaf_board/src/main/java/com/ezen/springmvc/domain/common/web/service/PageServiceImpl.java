package com.ezen.springmvc.domain.common.web.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.springmvc.domain.board.dto.Board;
import com.ezen.springmvc.domain.common.web.mapper.PaginationMapper;

import lombok.RequiredArgsConstructor;

/**
 * 게시판 관련 비즈니스 로직 처리 및 트랜잭션 관리 구현체
 * @author 홍재헌
 */
@RequiredArgsConstructor
@Service
public class PageServiceImpl implements PageService {
	
	private final PaginationMapper paginationMapper;

	
	
}
