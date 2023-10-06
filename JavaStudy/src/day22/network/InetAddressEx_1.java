package day22.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressEx_1 {
//InetAddress 클래스 : ip를 다루기 위한 클래스. 접근제한자가 default이므로 직접 객체를 생성할 수 없다.
//????????????? 직접 객체를 생성할 수 없다. 왜였지?? 생성자가 없나?
//답 : 
	public static void main(String[] args) {
		//1. checked Exception
		try {
			//2. InetAddress 객체 생성
			//getByName 메서드로 InetAddress 객체 생성 - 직접 객체를 생성할 수 없어서 메서드로 정보를 받아온다.
			InetAddress ip = InetAddress.getByName("www.google.co.kr");
			
			//3. getHostName() - InetAddress의 호스트 이름(DNS)
			System.out.println(ip.getHostName());
			
			//4. getHostAddress() - InetAddress의 호스트 주소, 프록시 서버의 주소
			System.out.println(ip.getHostAddress());
			
			//5. getAllByName() - InetAddress 객체 배열 생성
			InetAddress[] ips = InetAddress.getAllByName("www.naver.com");
			//getAllByName() - 관련 주소 정보를 모두 출력. 배열로 반환 
			for(InetAddress i : ips) {
				System.out.println("ip 주소 : "+i);
			}
			
			//6. getAddress() - 주소값을 byte[] 배열로 리턴
			byte[] idArr = ip.getAddress();
			//byte 자료형의 표현 범위 -128(1000 0000) ~ 127(0111 1111)
			for(byte b : idArr) {
//				System.out.println(b);
				System.out.print(((b<0)? b+256:b)+".");
			}
			System.out.println();
			
			//7. getLocalHost() - InetAddress 로컬 호스트 주소 리턴
			InetAddress local = InetAddress.getLocalHost();
			System.out.println("내 컴퓨터 IP : "+local);
			
			//8. getByAddress() - InetAddress 배열 내부의 아이피 주소만 가져오기
			InetAddress ip2 = InetAddress.getByAddress(ips[0].getAddress());
			System.out.println(ips[0].getHostName()+" 주소 : "+ip2);
			
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		}
	}

}
