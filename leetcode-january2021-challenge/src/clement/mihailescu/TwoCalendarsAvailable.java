package clement.mihailescu;

public class TwoCalendarsAvailable {

    static String[][] schedule1 = {{"9:00", "10:00"}, {"10:30", "12:00"}, {"15:00","16:30"}};
    static String[] boundary1 = {"8:00", "15:00"};
    static String[][] schedule2 = {{"8:00", "9:30"}, {"10:00", "11:00"}, {"16:00","17:00"}};
    static String[] boundary2 = {"7:00", "17:00"};

    public static void main(String[] args) {
        String[][] result = TwoCalendarsAvailable.getFreeAgendaTime();
        System.out.println(result);
    }

    private static String[][] getFreeAgendaTime() {
        for(String[] s1 : schedule1) {
            for(String[] s2 : schedule2) {

                String s1FirstHour = s1[0].split(":")[0];
                String s1FirstMinute = s1[0].split(":")[1];
                String s1LastHour = s1[1].split(":")[0];
                String s1LastMinute = s1[1].split(":")[1];

                String s2FirstHour = s2[0].split(":")[0];
                String s2FirstMinute = s2[0].split(":")[1];
                String s2LastHour = s2[1].split(":")[0];
                String s2LastMinute = s2[1].split(":")[1];

                //TODO for hour
                if(s2FirstHour.compareTo(s1LastHour) <= 0)
                    break;

                String r1 = getBusyRangeTime(s1FirstHour, s1FirstMinute, s2FirstHour, s2FirstMinute);
                String r2 = getBusyRangeTime(s1LastHour, s1LastMinute, s2LastHour, s2LastMinute);
                System.out.println(r1+":"+r2);
            }
        }

        return null;
    }

    public static String getBusyRangeTime(String s1FirstHour, String s1FirstMinute, String s2FirstHour, String s2FirstMinute) {
        String busyHour = "", busyMinute = "";

        String[] result = new String[2];
        if (s1FirstHour.compareTo(s2FirstHour) < 0) {
            busyHour = s1FirstHour;
            busyMinute = s1FirstMinute;
        } else if (s1FirstHour.compareTo(s2FirstHour) > 0) {
            busyHour = s2FirstHour;
            busyMinute = s2FirstMinute;
        } else {
            if (s1FirstMinute.compareTo(s2FirstMinute) < 0) {
                busyHour = s1FirstHour;
                busyMinute = s1FirstMinute;
            } else {
                busyHour = s2FirstHour;
                busyMinute = s2FirstMinute;
            }
        }

        return busyHour+":"+busyMinute;
    }
}
