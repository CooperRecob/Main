package enhancedForLoop;

public class Date {
    private String month;
    private int day;
    private int year;

    public Date(String month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public Date() {
        month = "January";
        day = 1;
        year = 2022;
    }

    public void displayMonthDayYear() {
        System.out.println(month + " " + day + ", " + year);
    }
}
