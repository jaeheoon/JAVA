package com.ezen.springbasic.guestbook;

import java.util.List;

public interface GuestbookService {
	public void register(Guestbook guestbook);
	public List<Guestbook> findGuestbooks();
}
