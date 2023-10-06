package day21.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamParallel_1 {
//Stream 병렬 처리
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<100; i++) {
			list.add(i);
		}
		
		//실행시간 계산
		long start = System.nanoTime();
		
		//순차적 스트림
		Stream<Integer> a1 = list.stream();
		a1.forEach(a -> {
			try {
				Thread.sleep(1);
				//1ms 멈춤
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		long end = System.nanoTime();
		System.out.println("병렬 처리 여부 : "+a1.isParallel());
		System.out.println("순차 스트림 처리 시간 : "+(end-start)+" nano sec");
		
		//병렬 스트림
		start = System.nanoTime();
		Stream<Integer> a2 = list.parallelStream();
		a2.forEach(a -> {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		end = System.nanoTime();
		System.out.println("병렬 처리 여부 : "+a2.isParallel());
		System.out.println("병렬 스트림 처리 시간 : "+(end-start)+" nano sec");
		
	}

}
