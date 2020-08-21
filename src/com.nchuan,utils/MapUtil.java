import java.util.*;
import java.util.Map.Entry;

/**
 * @author 32733
 * @Description //TODO
 * @Date 2020/8/21 15:13
 */
public class MapUtil {
    /**
     * ������Mapת��������Map
     * @explain ���������յ�һ���ַ��ļ�ֵ ASCII �����������ĸ�������򣩣����������ͬ�ַ����յڶ����ַ��ļ�ֵ ASCII ���������
     *          �Դ�����ͨ��SortedMap����ʵ��
     * @param paramsMap
     * @return Map ��ASCII����������
     */
    public static Map<String, Object> toSortedMap(Map<String, Object> paramsMap) {
        // ���ڴ洢���յ���key:value������key��ASCII����������������
        SortedMap<String, Object> data = new TreeMap<String, Object>();
        // ��ȡMap�����еļ�ֵ�Զ���
        Set<Entry<String, Object>> entrySet = paramsMap.entrySet();
        Entry<String, Object> entry = null;
        String key = "";
        Object value = null;
        // ����paramsMap���ݣ���ӵ�SortedMap����
        for (Entry<String, Object> stringObjectEntry : entrySet) {
            entry = stringObjectEntry;
            key = entry.getKey();
            value = entry.getValue();
            data.put(key, value);
        }
        return data;
    }
}
