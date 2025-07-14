package com.hbb.utils.finger.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.annotation.ExcelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * 百万级 Excel 导出( 使用 EasyExcel (阿里巴巴开源库))
 * 注意：excel 文件本身支持最大行数有限制（0..1048575） 超过请导出为多个文件
 */
public class EasyExcelBatchWriteFixed {

    public static void main(String[] args) {
        String fileName = "large_data_test_fixed.xlsx";
        writeInBatches(fileName);
    }

    private static void writeInBatches(String fileName) {
        // 1. 先构建 WriteSheet（确保唯一）
        WriteSheet writeSheet = EasyExcel.writerSheet("Sheet1").build();

        // 2. 创建 ExcelWriter，并传入 WriteSheet（避免自动创建默认 Sheet）
        ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build();

        try {
            // 3. 分批次写入数据
            List<DemoData> batchData = new ArrayList<>();
            for (int i = 0; i < 1_000_000; i++) {
                batchData.add(new DemoData(i, "用户" + i, 20 + (i % 30), "user" + i + "@example.com"));

                if (batchData.size() >= 5000) {
                    excelWriter.write(batchData, writeSheet);
                    batchData.clear();
                }
            }

            // 4. 写入剩余数据
            if (!batchData.isEmpty()) {
                excelWriter.write(batchData, writeSheet);
            }
        } finally {
            // 5. 确保关闭 ExcelWriter
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }

    // 数据模型类
    public static class DemoData {
        @ExcelProperty("ID")
        private Integer id;

        @ExcelProperty("姓名")
        private String name;

        @ExcelProperty("年龄")
        private Integer age;

        @ExcelProperty("邮箱")
        private String email;

        // 必须有无参构造方法
        public DemoData() {}

        public DemoData(Integer id, String name, Integer age, String email) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.email = email;
        }

        // Getter & Setter
        public Integer getId() { return id; }
        public void setId(Integer id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public Integer getAge() { return age; }
        public void setAge(Integer age) { this.age = age; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
    }
}