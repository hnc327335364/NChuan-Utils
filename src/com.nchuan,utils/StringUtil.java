import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 32733
 * @Description //TODO
 * @Date 2020/8/21 15:18
 */
public class StringUtil {
    private static String NULL_ERR = "The passed parameter is null,Please Check it";
    private static String INVALID_SYMBOL_ERR = "Please provide a valid symbol";
    private static String FILE_SUFFIX_ERR = "The file suffix name may not exist";

    /**
     * 将List<String>类型数组转换成用“，”隔开的字符串
     * @param listStr String数组
     * @param symbol 分隔符
     * @return String
     */
    public static String listConvertStr(List<String> listStr,String symbol) {
        if (listStr.isEmpty()){
            throw new NullPointerException(NULL_ERR);
        }
        if (symbol==null){
            throw new NullPointerException(INVALID_SYMBOL_ERR);
        }
        StringBuilder sb = new StringBuilder();
        for (String item : listStr) {
            sb.append(item).append(symbol);
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    /**
     * 将字符串转换成list数组，其中根据参数symbol（符号）来进行分割
     * @param str 需要转换的字符串
     * @param symbol 分割字符
     * @return string类型的数组
     */
    public static List<String> strConvertList(String str , String symbol) {
        if (str.isEmpty()){
            throw new NullPointerException(NULL_ERR);
        }
        if (symbol==null){
            throw new NullPointerException(INVALID_SYMBOL_ERR);
        }
        List<String> list = new ArrayList<String>();
        String[] strArr = str.split(symbol);
        Collections.addAll(list, strArr);
        return list;
    }

    /**
     * 获取文件的后缀名
     * @param fileName 文件的全民
     * @return 文件的拓展名
     */
    public static String getSuffixName(String fileName)  {
        if (null != fileName && !"".equals(fileName)) {
            if (fileName.lastIndexOf(".") > 0) {
                return fileName.substring(fileName.lastIndexOf("."), fileName.length());
            }else {
                throw new NullPointerException(FILE_SUFFIX_ERR);
            }
        }
        return "";
    }


}
