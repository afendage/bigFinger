package com.hbb.utils;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * 文件工具类-操作案列
 */
public class FileUtilTest {

    /**
     * 删除该文件夹下的所有东西
     */
    @Test
    public void delFolderFiles() throws IOException {
        File file = new File("D:\\files\\clearFiles");
        FileUtils.cleanDirectory(file);
    }

    /**
     * 测试两个文件的内容相不相同
     */
    @Test
    public void contentEquals() throws IOException {
        File file = new File("D:\\files\\aa.txt");
        File file1 = new File("D:\\files\\bb.txt");
        boolean b = FileUtils.contentEquals(file, file1);
        System.out.println(b);
    }

    /**
     * 复制第一个参数的文件夹下的所有内容复制到第二个参数的文件夹下
     */
    @Test
    public void copyDirectory() throws IOException {
        File f1 = new File("D:\\files");
        File f2 = new File("D:\\files\\copyFiles");
        FileUtils.copyDirectory(f1,f2);
    }

    /**
     * 将第一个参数的整个文件夹复制到第二个路径下
     */
    @Test
    public void copyDirectoryToDirectory() throws IOException {
        File f1 = new File("D:\\files");
        File f2 = new File("D:\\files\\copyFiles");
        FileUtils.copyDirectoryToDirectory(f1,f2);
    }

    /**
     * 将一个文件的内容复制到另一个文件中
     */
    @Test
    public void copyFile() throws IOException {
        File f1 = new File("D:\\files\\cc.xlsx");
        File f2 = new File("D:\\files\\dd.xlsx");
        FileUtils.copyFile(f2,f1);
    }

    /**
     * 将一个文件的内容复制到另一个文件中
     */
    @Test
    public void copyFileToDirectory() throws IOException {
        File f1 = new File("D:\\files\\cc.xlsx");
        File f2 = new File("D:\\files\\copyFiles");
        FileUtils.copyFileToDirectory(f1,f2);
    }

    /**
     * 读取文件内容返回String,原样输出
     */
    @Test
    public void readFileToString() throws IOException {
        File f1 = new File("D:\\files\\aa.txt");
        String str = FileUtils.readFileToString(f1,"UTF-8");
        System.out.println(str);
    }

    /**
     * 返回String集合
     */
    @Test
    public void readLines() throws IOException {
        File f1 = new File("D:\\files\\aa.txt");
        List<String> list = FileUtils.readLines(f1,"UTF-8");
        System.out.println(JSONObject.wrap(list));
    }

    /**
     * 将String数据写入文件(只能输入一行,如果后续还有输入,将覆盖前面的内容,下一个方法将是追加)
     */
    @Test
    public void writeStringToFile() throws IOException {
        File f1 = new File("D:\\files\\aa.txt");
        FileUtils.writeStringToFile(f1,"append data one line to file......","UTF-8");
    }

    /**
     * 将String数据写入文件,多个string数据就追加(记住一点文件里不会换行)
     */
    @Test
    public void writeStringToFile1() throws IOException {
        File f1 = new File("D:\\files\\aa.txt");
        FileUtils.writeStringToFile(f1,"append data to file......","UTF-8",true);
    }

    /**
     * 获取一个网页的源代码,写入本地文件,还可以向本地写图片的等等
     * 获取页面
     */
    @Test
    public void copyURLToFile() throws IOException {
        String url = "https://blog.csdn.net/lixin2302007/article/details/78354929";
        FileUtils.copyURLToFile(new URL(url),new File("D:\\files\\test.html"));
    }

    /**
     * 获取一个网页的源代码,写入本地文件,还可以向本地写图片的等等
     * 写图片
     */
    @Test
    public void copyURLToFile1() throws IOException {
        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1525082437668&di=18d455af6f3ffedc1f4d2e022cfe4af5&imgtype=0" +
                "&src=http%3A%2F%2Fpic.eastlady.cn%2Fuploads%2Ftp%2F201705%2F9999%2F7e03b578dc.jpg";
        FileUtils.copyURLToFile(new URL(url),new File("D:\\files\\test.jpg"));
    }
}
