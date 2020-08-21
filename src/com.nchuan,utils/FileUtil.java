import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 32733
 * @Description //�����ļ��Ĺ�����
 * @Date 2020/8/21 14:11
 */
public class FileUtil {

    /**
     * ��ȡtxt�ļ�
     * @param fileName����Ҫ��ȡtxt�ļ���·��
     * @return ���ض�ȡ�������ݣ����������һ��list������
     */
    public static List<String> readTxt(String fileName){
        try {
            File file = new File(fileName);
            //�ж϶�ȡ���ļ��Ƿ��У����û�оʹ���һ���յģ���ʵ���ﲻ����Ҳ����,��Ϊ�����쳣
            if(!file.exists()){
                file.createNewFile();
            }
            //�򿪶�ȡtxt�ļ���
            FileInputStream fr = new FileInputStream(file);
            InputStreamReader af=new InputStreamReader(fr);
            BufferedReader bf=new BufferedReader(af);
            //���ڴ洢��ȡ��������
            List<String> content = new ArrayList<String>();
            String line=bf.readLine();
            content.add(line);
            //�ж��Ƿ��ȡ�����
            while(line!=null)
            {
                line=bf.readLine();
                //�����ȡ����
                content.add(line);
            }
            return content;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }


    /**
     * ������д�뵽TXT�ļ�
     * @param list : �������ݣ������õ���list������Ϊ��������
     * @param fileName :Ҫд����ļ���
     */
    public static void writeContent2Txt(List<String> contentList , String fileName){
        File writeTxt = new File(fileName);
        //�ж��Ƿ�������ļ���
        if(!writeTxt.exists()){ //���������,�򴴽����txt�ļ�
            try {
                writeTxt.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //����д����
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(writeTxt));
            // ��ȡ������д�����ݵĴ�С����
            int writeLength = contentList.size();
            String currentContent = "";
            for(int i = 0 ; i < writeLength ; i++){
                //�õ���ǰ������
                currentContent = contentList.get(i);
                //�����ȡ������Ϊ@@����ʾ���ǻ���
                if("@@".equals(currentContent)){
                    bw.write("\r\n"); // "\r\n"��ʾ����
                }else{
                    bw.write(currentContent);
                    bw.write("\r\n"); // "\r\n"��ʾ����
                }
            }
            bw.flush();
            bw.close(); //�ر���
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * ��ȡ���ݣ���д�뵽doc���ļ���
     * @param contentList ��Ҫд��Դ��������
     * @param fileName д�����ļ�·��������F��\\text.doc
     */
    public static void writeContent2Word(List<String> contentList , String fileName){
        try {
            File file = new File(fileName);
            //�ж�Ŀ��·���Ƿ����
            if(!file.exists()){
                file.createNewFile();
            }
            //���ļ������
            FileOutputStream fo=new FileOutputStream(file);
            OutputStreamWriter osw=new OutputStreamWriter(fo);
            BufferedWriter bw=new BufferedWriter(osw);
            //��ȡ��ȡ�ĳ��ȵĴ�С
            int contentLength = contentList.size();
            String content = "";
            for(int i = 0 ; i < contentLength; i++){
                //��ȡ��Ҫд������
                content = contentList.get(i);
                bw.write(content);
                //����
                bw.newLine();
                //ˢ�»�����
                bw.flush();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}
