package site.zhourui.jasperreportdemo.controller;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.zhourui.jasperreportdemo.entity.po.Address01;
import site.zhourui.jasperreportdemo.mapper.BaseMapper;

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

    @Autowired
    private SqlSession sqlSession;
    @RequestMapping("/sql")
    public void generateReport(HttpServletResponse response) throws Exception {
        // Fetch data from database
        Resource resource = new ClassPathResource("templates/address.jasper");

        try (FileInputStream is = new FileInputStream(resource.getFile());
             ServletOutputStream os = response.getOutputStream()) {
            Address01 address01= sqlSession.selectOne("site.zhourui.jasperreportdemo.mapper.Address01Mapper.selectById", 1);
            // Create a JRBeanCollectionDataSource using the address01 object
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(Collections.singletonList(address01));
            // Set response headers
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=report.pdf");

            // Create JasperPrint object and fill report
            JasperPrint jasperPrint = JasperFillManager.fillReport(is, null, dataSource);

            // Export report to PDF
            JasperExportManager.exportReportToPdfStream(jasperPrint, os);

            os.flush();
        }
    }




}
