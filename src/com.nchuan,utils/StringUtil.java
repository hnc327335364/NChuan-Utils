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
     * ��List<String>��������ת�����á������������ַ���
     * @param listStr String����
     * @param symbol �ָ���
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
     * ���ַ���ת����list���飬���и��ݲ���symbol�����ţ������зָ�
     * @param str ��Ҫת�����ַ���
     * @param symbol �ָ��ַ�
     * @return string���͵�����
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
     * ��ȡ�ļ��ĺ�׺��
     * @param fileName �ļ���ȫ��
     * @return �ļ�����չ��
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
