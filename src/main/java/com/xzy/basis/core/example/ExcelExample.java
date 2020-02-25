package com.xzy.basis.core.example;

import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author: xzy
 * @Description:
 * @Date: Created in 16:23 2020/2/25
 */
public class ExcelExample {
    public void exportExcelExample(HttpServletResponse response){
        try{
            String fileName="导出excel例子";
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
            OutputStream outputStream = response.getOutputStream();

            //准备导出的数据
            Map map=new HashMap(16);
            //需要做导出的数据，需要在此处对list赋值
            List<Object> list=new LinkedList<>();
            //将需要导出的数据放入map，需要修改excel中的表达式，对应导出数据的model
            map.put("data",list);
            // 获取模板文件
            InputStream is = this.getClass().getResourceAsStream("/excel/exportExample.xlsx");
            // 实例化 XLSTransformer 对象
            XLSTransformer xlsTransformer = new XLSTransformer();
            // 获取 Workbook ，传入 模板 和 数据
            Workbook workbook = xlsTransformer.transformXLS(is, map);
            // 写出文件
//            OutputStream os = new BufferedOutputStream(new FileOutputStream("D://temp.xls"));
            // 输出
            workbook.write(outputStream);
            // 关闭和刷新管道，不然可能会出现表格数据不齐，打不开之类的问题
            is.close();
            outputStream.close();
        }catch (IOException | InvalidFormatException e){
            e.printStackTrace();
        }

    }
}
