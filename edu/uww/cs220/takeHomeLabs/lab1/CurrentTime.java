package edu.uww.cs220.takeHomeLabs.lab1;

import java.util.*;
import java.text.*;

public class CurrentTime {

	public static void main(String[] args) {

		// obtain total milliseconds since midnight, Jan. 1, 1970
		long totalMilliseconds = System.currentTimeMillis();

		// obtain the total seconds since midnight, Jan. 1, 1970
		long totalSeconds = totalMilliseconds / 1000;

		// Compute current seconds (use modular operation)
		int currentSecond = (int) (totalSeconds % 60);

		// obtain the total minutes (use integer division)
		long totalMinutes = totalSeconds / 60;

		// Compute current minute (use modular operation)
		int currentMinute = (int) (totalMinutes % 60);

		// obtain the total hours (use integer division)
		long totalHours = totalMinutes / 60;

		// Compute current hour (use modular operation)
		int currentHour = (int) (totalHours % 24);

		// Display results by using println(), and use the format HH:MM:SS
		System.out.println(
				"Current Greenwich Mean Time (GMT)\n" + currentHour + ":" + currentMinute + ":" + currentSecond);

		// bonus 1: keep 2-digit format in displaying time (e.g., 09 instead of 9)
		DecimalFormat df = new DecimalFormat("00");
		System.out.println("Current Greenwich Mean Time (GMT)\n" + df.format(currentHour) + ":" + df.format(currentMinute) + ":" + df.format(currentSecond));

		// bonus 2: display current local date and time in a specified format?
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		System.out.println("Current Greenwich Mean Time (GMT)\n" + sdf.format(new Date()));

	}

}
