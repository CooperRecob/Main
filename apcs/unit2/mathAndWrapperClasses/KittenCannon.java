package apcs.unit2.mathAndWrapperClasses;

public class KittenCannon {
	private double angle;
	private double velocity;
	
	public KittenCannon(double angle, double velocity) {
		this.angle = angle;
		this.velocity = velocity;
	}
	
	public double getDistance() {
		angle = Math.toRadians(angle);
		return Math.sin(angle * 2) * Math.pow(velocity, 2) / 9.8;
	}
}
