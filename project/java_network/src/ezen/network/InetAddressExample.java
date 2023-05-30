package ezen.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * DNS와의 통신을 이용해 도메인 이름을 아이피 주소 정보를 제공
 * @author 홍재헌
 * 230530 수업
 */
public class InetAddressExample {

	public static void main(String[] args) throws UnknownHostException {
		String localIp = null;
		InetAddress inetAddress = InetAddress.getLocalHost();
		localIp = inetAddress.getHostAddress();
		System.out.println("내 컴퓨터의 IP 주소: "+localIp);
		
		String domainName = "www.naver.com";
//		String domainName = "www.google.com";
		String naverIp = null;
		inetAddress = InetAddress.getByName(domainName);
		System.out.println(inetAddress.getHostAddress());
		
		InetAddress[] mutiIps = InetAddress.getAllByName(domainName);
		for (InetAddress inet : mutiIps) {
			System.out.println(inet);
		}
	}

}
