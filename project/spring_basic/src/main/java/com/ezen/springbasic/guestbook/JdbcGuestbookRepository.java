package com.ezen.springbasic.guestbook;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class JdbcGuestbookRepository implements GuestbookRepository{
	
	@Override
	public void create(Guestbook guestbook) {
		System.out.println(guestbook.toString() + "등록 완료");
	}

	@Override
	public List<Guestbook> findAll() {
		List<Guestbook> list = new ArrayList<Guestbook>();
		list.add(new Guestbook("멍게", "멍게 맛있습니다."));
		list.add(new Guestbook("꼴뚜기", "꼴뚜기 맛있습니다."));
		return list;
	}
}
