package com.ezen.springmvc.domain.member.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.springmvc.domain.member.dto.Member;
import com.ezen.springmvc.domain.member.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

/**
 * 회원 관련 비즈니스 로직 처리 및 트랜잭션 관리 구현체
 * @author 홍재헌
 */
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
	
	private final MemberMapper memberMapper;

	//트랜잭션을 필요한 곳에만 선언해주는 것이 좋다
	@Override
	@Transactional
	public void register(Member member) {
		memberMapper.create(member);
	}

	@Override
	public Member isMember(String id, String passwd) {
		return memberMapper.findByIdAndPasswd(id, passwd);
	}

	@Override
	public List<Member> getMemberList() {
		return memberMapper.findByAll();
	}

	@Override
	public Member getMember(String id) {
		return memberMapper.findById(id);
	}
	
}
