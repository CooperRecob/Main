package arrayAssignment;

public class GolfCourse {
	private int [] holePar = {0, 0, 0, 0, 0, 0, 0, 0, 0};

	public GolfCourse(int [] holePar) {
		this.holePar = holePar;
	}

	public GolfCourse() {
		for (int i = 0; i < holePar.length; i++) {
			holePar [i] = (int) (Math.random() * 3 + 3);
		}
	}

	public void displayCourseInfo() {
		for (int i = 0; i < holePar.length; i++) {
			System.out.println("Hole " + (i + 1) + "\'s Par is " + holePar[i]);
		}
	}

	public void playRound() {
		int holeNum = holePar [(int) (Math.random() * holePar.length)];
		int par = (int) (Math.random() * 9);
		int overUnder = holePar [holeNum] - par;

		if (par >= holePar [holeNum]) {
			System.out.println("On hole " + holeNum + " Your were " + Math.abs(overUnder) + " over on a par of " + holePar [holeNum] + " with a par of " + par);
		} else {
			System.out.println("On hole " + holeNum + " Your were " + Math.abs(overUnder) + " under on a par of " + holePar [holeNum] + " with a par of " + par);
		}
	}
}
