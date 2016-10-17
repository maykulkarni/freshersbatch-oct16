public class Date implements Cloneable {
    private int date;
    private int month;
    private int year;

    public void setDate(int date) {
        this.date = date;
    }

    public int getDate() {
        return this.date;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getMonth() {
        return this.month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return this.year;
    }

    public Date() {

    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Date(int date, int month, int year) {
        setDate(date);
        setMonth(month);
        setYear(year);
    }

    public void printDate() {
        System.out.println(getDate() + "-" + getMonth() + "-" + getYear());
    }

    public static void swapDates(Date[] dateArr) {
        Date tmpDate = dateArr[0];
        dateArr[0] = dateArr[1];
        dateArr[1] = tmpDate;
    }

    public static void main(String[] args) {
        Date d = new Date(24, 1, 1995);
        Date p = new Date(25, 4, 1994);
        d.printDate();
        p.printDate();
        Date[] dates = new Date[2];
        dates[0] = d;
        dates[1] = p;
        swapDates(dates);
        d = dates[0];
        p = dates[1];
        d.printDate();
        p.printDate();
    }
}