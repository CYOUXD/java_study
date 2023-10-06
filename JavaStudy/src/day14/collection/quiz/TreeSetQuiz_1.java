package day14.collection.quiz;

import java.util.Random;
import java.util.TreeSet;

public class TreeSetQuiz_1 {
//TreeSet을 이용하여 로또번호 6개를 생성
	public static void main(String[] args) {
		TreeSet<Integer> lotto = new TreeSet<>();
		
		Random r = new Random();
		while(true) {
			int rn = r.nextInt(45)+1;
			//nextInt() : () 범위 내의 랜덤한 int 값을 반환(0<= r < 45 = 0~44)
			
			lotto.add(rn);
			
			if(lotto.size() == 6) {
				break;
			}
		}
		System.out.print(lotto+" ");
	}

}
