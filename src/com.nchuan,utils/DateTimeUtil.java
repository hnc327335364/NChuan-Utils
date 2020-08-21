import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 32733
 * @Description //时间日期工具类
 * @Date 2020/8/21 10:48
 */
public class DateTimeUtil {

    public static enum TIME_TYPE {YEAR, MONTH, WEEK, DAY, HOURS,MINS,SECS,MILLS};
    public static enum SORT_TYPE {DESC,ASC};

    private static String INVALID_DATE_ERR = "Please provide a valid Date";
    private static String INVALID_CAL_ERR = "Please provide a valid Calendar";
    private static String STRING_FMT_ERR = "Please provide a valid String";

    /**
     * 将日期格式成固定固定格式的String字符串对象
     * @param date 原日期
     * @param format 格式
     * @return String 字符串
     */
    public static  String formatDate(Date date, String format){
        if(date == null){
            throw new NullPointerException(INVALID_DATE_ERR);
        }
        if(format == null){
            throw new NullPointerException(STRING_FMT_ERR);
        }
        if(format.length() == 0){
            throw new IllegalArgumentException(STRING_FMT_ERR);
        }

        SimpleDateFormat dateFormatter = new SimpleDateFormat(format);
        return dateFormatter.format(date);
    }

    /**
     * 将String类型的日期转换从日期
     * @param formattedString 需要转换的String日期
     * @return Date 日期
     * @throws ParseException 格式化异常
     */
    public static Date getDateFromString(String formattedString) throws ParseException{
        if(formattedString == null){
            throw new NullPointerException(STRING_FMT_ERR);
        }
        if(formattedString.length() == 0){
            throw new IllegalArgumentException(STRING_FMT_ERR);
        }
        SimpleDateFormat dateFormatter = new SimpleDateFormat();

        return dateFormatter.parse(formattedString);
    }

    /**
     * 将日历类对象转换成固定格式的Sting字符串
     * @param calendar 原日历类
     * @param format 格式
     * @return  String 字符串
     */
    public static String formatDate(Calendar calendar, String format){
        if(calendar == null){
            throw new NullPointerException(INVALID_CAL_ERR);
        }
        if(format == null){
            throw new NullPointerException(STRING_FMT_ERR);
        }
        if(format.length() == 0){
            throw new IllegalArgumentException(STRING_FMT_ERR);
        }

        SimpleDateFormat dateFormatter = new SimpleDateFormat(format);

        return dateFormatter.format(calendar.getTime());
    }

    /**
     * 将String类型转换为日历类
     * @param formattedString 需要转换的String字符串
     * @return Calendar日历类
     * @throws ParseException
     */
    public static Calendar getCalendarFromString(String formattedString) throws ParseException{
        if(formattedString == null){
            throw new NullPointerException(STRING_FMT_ERR);
        }
        if(formattedString.length() == 0){
            throw new IllegalArgumentException(STRING_FMT_ERR);
        }

        SimpleDateFormat dateFormatter = new SimpleDateFormat(formattedString);
        Date date = dateFormatter.parse(formattedString);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return cal;
    }

    /**
     * 根据入参判断来对时间进行加减运算
     * @param date 用来计算的时间
     * @param timeType 计算类型（年、月、日、时、分、秒、毫秒）
     * @param count 时间增减量
     * @return Date 计算后的时间
     */
    public static Date doDateCalculate(Date date, TIME_TYPE timeType, Integer count ){
        if (date == null){
            throw new NullPointerException(INVALID_DATE_ERR);
        }
        GregorianCalendar gc = new GregorianCalendar();
        switch (timeType){
            case YEAR:
                gc.add(Calendar.YEAR,count);
                break;
            case MONTH:
                gc.add(Calendar.MONTH,count);
                break;
            case WEEK:
                gc.add(Calendar.WEEK_OF_YEAR,count);
                break;
            case DAY:
                gc.add(Calendar.DAY_OF_YEAR,count);
                break;
            case HOURS:
                gc.add(Calendar.HOUR,count);
                break;
            case MINS:
                gc.add(Calendar.MINUTE,count);
                break;
            case SECS:
                gc.add(Calendar.SECOND,count);
                break;
            case MILLS:
                gc.add(Calendar.MILLISECOND,count);
                break;
            default:
                return date;
        }
        return gc.getTime();
    }

    /**
     * 时间排序，根据传入的List时间列表和SORT_TYPE来进行升降排序
     * @param dateList 事件列表
     * @param sortType 排序类型（升序，降序）
     * @return 排序后的时间列表
     */
    public static List<Date> sortByDate(List<Date> dateList,SORT_TYPE sortType){
        if (dateList.isEmpty()){
            throw new NullPointerException(INVALID_DATE_ERR);
        }
        dateList.sort(new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return o1.compareTo(o2);
            }
        });

        if (sortType==SORT_TYPE.ASC) {
            Collections.reverse(dateList);
        }else if (sortType==SORT_TYPE.DESC){
            return dateList;
        }
        return dateList;
    }


}

