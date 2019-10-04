package com.hbb.springdemo.controller;

import com.hbb.utils.finger.bean.Person;
import com.hbb.utils.finger.util.ExcelUtil_By_Easypoi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/excel/")
public class ExcelDemeController {

    @RequestMapping("export")
    public void export(HttpServletResponse response){

        //模拟从数据库获取需要导出的数据
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person("路飞","1",new Date());
        Person person2 = new Person("娜美","2",new Date());
        Person person3 = new Person("索隆","1", new Date());
        Person person4 = new Person("小狸猫","1",new Date());
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        //导出操作
        try {
            ExcelUtil_By_Easypoi.exportExcel(personList,"花名册","草帽一伙",Person.class,"海贼王.xls",response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("importExcel")
    public void importExcel(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String filePath = "D:\\海贼王.xls";
        //解析excel，
        List<Person> personList = null;
        try {
            personList = ExcelUtil_By_Easypoi.importExcel(filePath,1,1, Person.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        for(int i=0;i<personList.size();i++){
            Person person = personList.get(i);
            System.out.println("姓名："+person.getName() +",性别："+person.getSex()+" ,生日："+format.format(person.getBirthday()));
        }
        System.out.println("导入数据一共【"+personList.size()+"】行");
    }

}
