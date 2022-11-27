import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.*;

public class lab2_1 {
    static boolean vaidator(String text) {
        Pattern mask = Pattern.compile("([0-9]{2}[\\/]){2}[0-9]{4}");
        Matcher match = mask.matcher(text);
       return match.matches();
    }

    static boolean checkData(String data) {
        short year = Short.parseShort(data.substring(6,10));
        if (year < 1900) { return false; }

        byte month = Byte.parseByte(data.substring(3,5));
        if (month > 12) { return false; }

        Calendar calendar = new GregorianCalendar();
        calendar.set(year, (month - 1), 1);

        byte day = Byte.parseByte(data.substring(0, 2));
        if (day > calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) { return false; }

        return true;
    }

    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);

       System.out.print("Дата: ");
       String data = scan1.nextLine();
       scan1.close();

        if (!lab2_1.vaidator(data)) {
            System.out.print("Введеное выражение не соответствует заданному формату даты dd/mm/yyyy");
            System.exit(-1);
        }

        if (lab2_1.checkData(data)) {
            System.out.print("Введенное выражение является датой");
            System.exit(0);
        }
        else {
            System.out.print("Введенное выражение не является датой");
            System.exit(0);
        }
    }
}
