import java.util.*;
import java.util.Map.Entry;

/**
 * @author 32733
 * @Description //TODO
 * @Date 2020/8/21 15:13
 */
public class MapUtil {
    /**
     * 将无序Map转换成有序Map
     * @explain 将参数按照第一个字符的键值 ASCII 码递增排序（字母升序排序），如果遇到相同字符则按照第二个字符的键值 ASCII 码递增排序，
     *          以此类推通过SortedMap可以实现
     * @param paramsMap
     * @return Map 按ASCII码升序排列
     */
    public static Map<String, Object> toSortedMap(Map<String, Object> paramsMap) {
        // 用于存储接收到的key:value，并按key以ASCII码进行升序排列组合
        SortedMap<String, Object> data = new TreeMap<String, Object>();
        // 获取Map对象中的键值对对象
        Set<Entry<String, Object>> entrySet = paramsMap.entrySet();
        Entry<String, Object> entry = null;
        String key = "";
        Object value = null;
        // 遍历paramsMap数据，添加到SortedMap对象
        for (Entry<String, Object> stringObjectEntry : entrySet) {
            entry = stringObjectEntry;
            key = entry.getKey();
            value = entry.getValue();
            data.put(key, value);
        }
        return data;
    }
}
