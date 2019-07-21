package www.sweet.test;

/**
 * Author:sweet
 * Created:2019/6/5
 */
public class Date {
    public int Year;
    public int Month;
    public int Day;
    public int Hour;
    public int Minute;
    public int Second;

    public Date(int year, int month, int day, int hour, int minute, int second) {
        Year = year;
        Month = month;
        Day = day;
        Hour = hour;
        Minute = minute;
        Second = second;
    }


    public static String findNum(String str){
        int len=str.length();
        int i=0;
        int count=0;
        int max=0;
        int index=0;
        while(i<len){
            int same=i+1;
            while (same<len){
                if(str.charAt(i)==str.charAt(same)){
                    count++;
                }else{
                    count=0;
                    break;
                }
                same++;
            }
            if(count!=0){
                index=i;
                max=count;
            }
            i++;
        }
        return str.substring(index-max+1,index+1);
    }



    /*
    * 每个字符进行判断，如果与后面的字符不相同则处理当前字符
    * 如果与后面字符相同，则进入判断，返回相同字符的个数
    *
    *
    * */
    public String DateFomatter(String date) {
        String[] strs=date.split("");
        StringBuffer sb=new StringBuffer();
        int len=strs.length;
        int count=0;
        int index=-1;

       while (len>=0){


       }

        return "";
    }

    public String dateJudge(String date) {
        if ("yyyy".equals(date)) {
            //1
            if (Year % 10 <= 0 && Year != 10) {
                return "000" + String.valueOf(Year);
            }
            //2位数
            if (Year % 100 <= 0 && Year != 100) {
                return "00" + String.valueOf(Year);

            }

            if (Year % 1000 <= 0 && Year != 1000) return "00" + String.valueOf(Year);

            return String.valueOf(Year);
        }

        if ("yy".equals(date)) {
            //判断Year
            if (Year % 10 <= 0 && Year != 10) {
                return "0" + String.valueOf(Year);
            }
            return String.valueOf(Year);
        }


        if ("MM".equals(date)) {
            if (Month > 0 && Month < 13) {
                if (Month < 10) {
                    return "0" + String.valueOf(Month);

                }
                return String.valueOf(Month);

            }
        }

        if ("M".equals(date)) {
            if (Month > 0 && Month < 13) {

                return String.valueOf(Month);
            }
        }


        if ("dd".equals(date)) {
            if (Month == 1 || Month == 3 || Month == 5 || Month == 7 || Month == 8 || Month == 10 || Month == 12) {
                if (Day > 0 && Day < 32) {
                    if (Day < 10) {
                        return "0" + String.valueOf(Day);
                    }
                    return String.valueOf(Day);

                }
            }
            if (Month == 2) {
                if (Day > 0 && Day < 30) {
                    if (Day < 10) {
                        return "0" + String.valueOf(Day);
                    }
                    return String.valueOf(Day);

                }
            }

            if (Month == 4 || Month == 6 || Month == 9 || Month == 11) {
                if (Day > 0 && Day < 31) {
                    if (Day < 10) {
                        return "0" + String.valueOf(Day);
                    }
                    return String.valueOf(Day);

                }

            }
        }


        if ("d".equals(date)) {
            if (Month == 1 || Month == 3 || Month == 5 || Month == 7 || Month == 8 || Month == 10 || Month == 12) {
                if (Day > 0 && Day < 32) {

                    return String.valueOf(Day);

                }
            }
            if (Month == 2) {
                if (Day > 0 && Day < 30) {

                    return String.valueOf(Day);

                }
            }

            if (Month == 4 || Month == 6 || Month == 9 || Month == 11) {
                if (Day > 0 && Day < 31) {
                    return String.valueOf(Day);
                }

            }
        }
        if ("HH".equals(date)) {
            if (Hour >= 0 && Hour <= 24) {
                if (Hour < 10) {
                    return "0" + String.valueOf(Hour);
                }
                return String.valueOf(Hour);

            }
        }
        if ("H".equals(date)) {
            if (Hour >= 0 && Hour <= 24) {

                return String.valueOf(Hour);

            }
        }
        if ("hh".equals(date)) {
            if (Hour >= 0 && Hour <= 24) {
                int hour = Hour % 13;
                if (hour < 10) {
                    return "0" + String.valueOf(hour);
                }
                return String.valueOf(hour % 12);

            }
        }
        if ("h".equals(date)) {
            if (Hour >= 0 && Hour <= 24) {
                int hour = Hour % 13;

                return String.valueOf(hour % 12);

            }
        }
        if ("mm".equals(date)) {
            if (Minute >= 0 && Minute <= 59) {
                if (Minute < 10) {
                    return "0" + String.valueOf(Minute);
                }
                return String.valueOf(Minute);
            }
        }
        if ("m".equals(date)) {
            if (Minute >= 0 && Minute <= 59) {

                return String.valueOf(Minute);
            }
        }
        if ("ss".equals(date)) {
            if (Second >= 0 && Second <= 59) {
                if (Second < 10) {
                    return "0" + String.valueOf(Second);
                }
                return String.valueOf(Second);
            }
        }

        if ("s".equals(date)) {
            if (Second >= 0 && Second <= 59) {

                return String.valueOf(Second);
            }
        }
        return date;
    }
}

