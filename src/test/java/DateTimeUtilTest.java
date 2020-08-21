import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author 32733
 * @Description //TODO
 * @Date 2020/8/21 12:02
 */
public class DateTimeUtilTest {


    @Test
    public void formatDate() {
        Date date = new Date();
        String format = "yyyy-MM-dd";
        String s = DateTimeUtil.formatDate(date, format);
        System.out.println(s);
    }


    @Test
    public void getDateFromString() {
    }

    @Test
    public void testFormatDate1() {
    }

    @Test
    public void getCalendarFromString() {
    }

    @Test
    public void doDateCalculate() throws ParseException {
        Date date = new Date();
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        Date parse = sdf.parse(format);
        Integer count = 2;
        Date date1 = DateTimeUtil.doDateCalculate(parse, DateTimeUtil.TIME_TYPE.MONTH, count);
        System.out.println(sdf.format(date1));
    }

    @Test
    public void sortByDate() throws InterruptedException {
        Date date1 = new Date();
        Thread.sleep(2000);
        Date date2 = new Date();
        Thread.sleep(2000);
        Date date3 = new Date();
        Thread.sleep(2000);
        Date date4 = new Date();
        Thread.sleep(2000);
        Date date5 = new Date();
        Thread.sleep(2000);
        List<Date> dateList = new ArrayList<>();
        dateList.add(date4);
        dateList.add(date2);
        dateList.add(date3);
        dateList.add(date5);
        dateList.add(date1);
        List<Date> dateList1 = DateTimeUtil.sortByDate(dateList, DateTimeUtil.SORT_TYPE.DESC);
        Assert.assertEquals(dateList,dateList1);
    }
}