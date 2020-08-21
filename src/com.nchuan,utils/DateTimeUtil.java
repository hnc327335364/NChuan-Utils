import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 32733
 * @Description //ʱ�����ڹ�����
 * @Date 2020/8/21 10:48
 */
public class DateTimeUtil {

    public static enum TIME_TYPE {YEAR, MONTH, WEEK, DAY, HOURS,MINS,SECS,MILLS};
    public static enum SORT_TYPE {DESC,ASC};

    private static String INVALID_DATE_ERR = "Please provide a valid Date";
    private static String INVALID_CAL_ERR = "Please provide a valid Calendar";
    private static String STRING_FMT_ERR = "Please provide a valid String";

    /**
     * �����ڸ�ʽ�ɹ̶��̶���ʽ��String�ַ�������
     * @param date ԭ����
     * @param format ��ʽ
     * @return String �ַ���
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
     * ��String���͵�����ת��������
     * @param formattedString ��Ҫת����String����
     * @return Date ����
     * @throws ParseException ��ʽ���쳣
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
     * �����������ת���ɹ̶���ʽ��Sting�ַ���
     * @param calendar ԭ������
     * @param format ��ʽ
     * @return  String �ַ���
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
     * ��String����ת��Ϊ������
     * @param formattedString ��Ҫת����String�ַ���
     * @return Calendar������
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
     * ��������ж�����ʱ����мӼ�����
     * @param date ���������ʱ��
     * @param timeType �������ͣ��ꡢ�¡��ա�ʱ���֡��롢���룩
     * @param count ʱ��������
     * @return Date ������ʱ��
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
     * ʱ�����򣬸��ݴ����Listʱ���б��SORT_TYPE��������������
     * @param dateList �¼��б�
     * @param sortType �������ͣ����򣬽���
     * @return ������ʱ���б�
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

