package ezen.oop.interfacee;

public class Gun implements Weapon{
	@Override
	public void attack() {
		System.out.println("총알을 발사합니다");
	}
}
