package ezen.oop.interfacee;

public class RemoteControlExample {

	public static void main(String[] args) {
		RemoteControl remocon = new Television();
		remocon.turnOn();
		remocon.setVolume(5);
		remocon.setVolume(100);
		remocon.setMute(true);
		remocon.setMute(false);
		remocon.turnOff();

		remocon = new Audio();
		remocon.turnOn();
		remocon.setVolume(5);
		remocon.setVolume(100);
		remocon.setMute(true);
		remocon.setMute(false);
		remocon.turnOff();

	}

}
