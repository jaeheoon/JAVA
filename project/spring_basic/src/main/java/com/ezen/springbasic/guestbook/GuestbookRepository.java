package com.ezen.springbasic.guestbook;

import java.util.List;

public interface GuestbookRepository {
	public void create(Guestbook guestbook);
	public List<Guestbook> findAll();
}
