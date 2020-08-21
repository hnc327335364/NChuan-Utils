import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 32733
 * @Description //操作文件的工具类
 * @Date 2020/8/21 14:11
 */
public class FileUtil {

    /**
     * 读取txt文件
     * @param fileName：需要读取txt文件的路径
     * @return 返回读取到的内容，保存的是在一个list集合中
     */
    public static List<String> readTxt(String fileName){
        try {
            File file = new File(fileName);
            //判断读取的文件是否有，如果没有就创建一个空的，其实这里不处理也可以,因为抛了异常
            if(!file.exists()){
                file.createNewFile();
            }
            //打开读取txt文件流
            FileInputStream fr = new FileInputStream(file);
            InputStreamReader af=new InputStreamReader(fr);
            BufferedReader bf=new BufferedReader(af);
            //用于存储读取到的内容
            List<String> content = new ArrayList<String>();
            String line=bf.readLine();
            content.add(line);
            //判断是否读取到最后
            while(line!=null)
            {
                line=bf.readLine();
                //保存读取内容
                content.add(line);
            }
            return content;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }


    /**
     * 将数据写入到TXT文件
     * @param list : 数据内容，这里用的是list集合作为参数内容
     * @param fileName :要写入的文件名
     */
    public static void writeContent2Txt(List<String> contentList , String fileName){
        File writeTxt = new File(fileName);
        //判断是否有这个文件了
        if(!writeTxt.exists()){ //如果不存在,则创建这个txt文件
            try {
                writeTxt.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //开启写操作
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(writeTxt));
            // 获取到进行写的内容的大小长度
            int writeLength = contentList.size();
            String currentContent = "";
            for(int i = 0 ; i < writeLength ; i++){
                //得到当前的内容
                currentContent = contentList.get(i);
                //如果读取的内容为@@，表示的是换行
                if("@@".equals(currentContent)){
                    bw.write("\r\n"); // "\r\n"表示换行
                }else{
                    bw.write(currentContent);
                    bw.write("\r\n"); // "\r\n"表示换行
                }
            }
            bw.flush();
            bw.close(); //关闭流
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 读取数据，并写入到doc的文件中
     * @param contentList 需要写的源数据内容
     * @param fileName 写到的文件路径，比如F：\\text.doc
     */
    public static void writeContent2Word(List<String> contentList , String fileName){
        try {
            File file = new File(fileName);
            //判断目标路径是否存在
            if(!file.exists()){
                file.createNewFile();
            }
            //打开文件输出流
            FileOutputStream fo=new FileOutputStream(file);
            OutputStreamWriter osw=new OutputStreamWriter(fo);
            BufferedWriter bw=new BufferedWriter(osw);
            //获取读取的长度的大小
            int contentLength = contentList.size();
            String content = "";
            for(int i = 0 ; i < contentLength; i++){
                //获取需要写的内容
                content = contentList.get(i);
                bw.write(content);
                //换行
                bw.newLine();
                //刷新缓存区
                bw.flush();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}
