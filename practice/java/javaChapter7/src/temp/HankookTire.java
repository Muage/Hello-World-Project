package temp;

public class HankookTire extends Tire {
	// 생성자
	public HankookTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	// 메서드
	@Override
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + " HankookTire 수명: " + (maxRotation-accumulatedRotation) + "회");
			return true;
		} else {	// 최대회전수 = 누적회전수
			System.out.println("*** " + location + " HankookTire 펑크 ***");
			return false;
		}
	}
}
