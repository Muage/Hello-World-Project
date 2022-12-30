package temp;

public class Tire {
	public int maxRotation;	// 최대회전수
	public int accumulatedRotation;	// 누적회전수
	public String location;
	
	public Tire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
	
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + " Tire 수명: " + (maxRotation-accumulatedRotation) + "회");
			return true;
		} else {	// 최대회전수 = 누적회전수
			System.out.println("*** " + location + " Tire 펑크 ***");
			return false;
		}
	}
}
