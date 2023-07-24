package site.zhourui.jasperreportdemo.controller;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author zr
 * @date 2023/7/20 14:52
 */
@RestController
@RequestMapping("/jasper")
public class demoController {
    /**
     * JasperReport的简单使用
     */
    @GetMapping("/test1")
    public void createHtml(HttpServletResponse response, HttpServletRequest request) throws Exception {
        Resource resource = new ClassPathResource("templates/demo.jasper");
        FileInputStream is = new FileInputStream(resource.getFile());
        ServletOutputStream os = response.getOutputStream();
        try {
            /**
             * 创建JasperPrint对象
             * 数据填充
             * is:inputstream params：参数填充 DataSource：数据源填充
             */
            JasperPrint jasperPrint = JasperFillManager.fillReport(is, new HashMap<>(), new JREmptyDataSource());
            // 写入pdf数据
            JasperExportManager.exportReportToPdfStream(jasperPrint, os);
        } finally {
            os.flush();
            os.close();
        }
    }

    /**
     * JasperReport的简单使用 (中文展示问题)
     * @param response
     * @throws Exception
     */
    @RequestMapping("/test2")
    public void test2(HttpServletResponse response) throws Exception{
        Resource resource = new ClassPathResource("templates/demo2.jasper");
        FileInputStream is = new FileInputStream(resource.getFile());
        ServletOutputStream os = response.getOutputStream();
        try {
            /**
             * 创建JasperPrint对象
             * 数据填充
             * is:inputstream params：参数填充 DataSource：数据源填充
             */
            JasperPrint jasperPrint = JasperFillManager.fillReport(is, new HashMap<>(), new JREmptyDataSource());
            // 写入pdf数据
            JasperExportManager.exportReportToPdfStream(jasperPrint, os);
        } finally {
            os.flush();
            os.close();
        }

    }

    /**
     * JasperReport携带参数
     * @param response
     * @throws Exception
     */
    @RequestMapping("/test3")
    public void test3(HttpServletResponse response) throws Exception{
        Resource resource = new ClassPathResource("templates/demo3.jasper");
        FileInputStream is = new FileInputStream(resource.getFile());
        ServletOutputStream os = response.getOutputStream();
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("year", "2023");
        parameters.put("name", "测试");
        try {
            /**
             * 创建JasperPrint对象
             * 数据填充
             * is:inputstream params：参数填充 DataSource：数据源填充
             */
            JasperPrint jasperPrint = JasperFillManager.fillReport(is, parameters, new JREmptyDataSource());
            // 写入pdf数据
            JasperExportManager.exportReportToPdfStream(jasperPrint, os);
        } finally {
            os.flush();
            os.close();
        }

    }

    /**
     * JasperReport携带参数 ,打印多页表单
     * @param response
     * @throws Exception
     */
    @RequestMapping("/test4")
    public void test4(HttpServletResponse response) throws Exception{
        Resource resource = new ClassPathResource("templates/demo4.jasper");
        FileInputStream is = new FileInputStream(resource.getFile());
        ServletOutputStream os = response.getOutputStream();
        Random random = new Random();

        List<HashMap> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            HashMap<String, String> item = new HashMap<String, String>();
            item.put("Field_1",  "员工-" + i);
            item.put("Field_2",  "部门-" + i);
            item.put("Field_3",  i%2==0?"男":"女");
            item.put("Field_4", String.valueOf(random.nextInt(10000 - 8000) + 8000 + 1));//8000-10000
            list.add(item);
        }
        JRDataSource dataSource = new JRBeanCollectionDataSource(list);
        try {
            /**
             * 创建JasperPrint对象
             * 数据填充
             * is:inputstream params：参数填充 DataSource：数据源填充
             */
            JasperPrint jasperPrint = JasperFillManager.fillReport(is, new HashMap<>(), dataSource);
            // 写入pdf数据
            JasperExportManager.exportReportToPdfStream(jasperPrint, os);
        } finally {
            os.flush();
            os.close();
        }

    }
}
