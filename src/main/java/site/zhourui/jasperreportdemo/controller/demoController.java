package site.zhourui.jasperreportdemo.controller;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleTextReportConfiguration;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.zhourui.jasperreportdemo.entity.po.Address01;
import site.zhourui.jasperreportdemo.entity.po.HKIDRecord;
import site.zhourui.jasperreportdemo.entity.po.PledgeRecord;
import site.zhourui.jasperreportdemo.mapper.BaseMapper;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author Bruce
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
    @RequestMapping("/hkid")
    public void generateReport2(HttpServletResponse response) throws Exception {
        // Fetch data from database
        Resource resource = new ClassPathResource("templates/tag_daily_summary_report.jasper");

        try (FileInputStream is = new FileInputStream(resource.getFile());
             ServletOutputStream os = response.getOutputStream()) {

            List<HKIDRecord> hkidRecordList = sqlSession.selectList("site.zhourui.jasperreportdemo.mapper.TagMapper.selectAll");
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(hkidRecordList);

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=report.pdf");

            // Create JasperPrint object and fill report
            JasperPrint jasperPrint = JasperFillManager.fillReport(is, null, dataSource);

            // Export report to PDF
            JasperExportManager.exportReportToPdfStream(jasperPrint, os);

            os.flush();
        }
    }

    @RequestMapping("/test")
    public void generateReport3(HttpServletResponse response) throws Exception {
        // Fetch data from database
        Resource resource = new ClassPathResource("templates/test.jasper");

        try (FileInputStream is = new FileInputStream(resource.getFile());
             ServletOutputStream os = response.getOutputStream()) {

            List<PledgeRecord> pledgeRecordList = generateTestPledgeRecords();
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(pledgeRecordList);

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=report.pdf");

            // Create JasperPrint object and fill report
            JasperPrint jasperPrint = JasperFillManager.fillReport(is, null, dataSource);

            // Export report to PDF
            JasperExportManager.exportReportToPdfStream(jasperPrint, os);

            os.flush();
        }
    }
    @RequestMapping("/hkidgroup")
    public void generateReportGroupBy(HttpServletResponse response) throws Exception {
        // Fetch data from database
        Resource resource = new ClassPathResource("templates/test2.jasper");

        try (FileInputStream is = new FileInputStream(resource.getFile());
             ServletOutputStream os = response.getOutputStream()) {

            List<HKIDRecord> hkidRecordList = sqlSession.selectList("site.zhourui.jasperreportdemo.mapper.TagMapper.selectAll");
            //sort the hkidRecordList by type
            Collections.sort(hkidRecordList, Comparator.comparing(HKIDRecord::getType));

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(hkidRecordList);

            response.setContentType("text/plain");
            response.setHeader("Content-Disposition", "attachment; filename=report.txt");

            // Create JasperPrint object and fill report
            JasperPrint jasperPrint = JasperFillManager.fillReport(is, null, dataSource);

            // Create text exporter
            JRTextExporter exporter = new JRTextExporter();



            // Configure exporter
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleWriterExporterOutput(os));


            SimpleTextReportConfiguration reportConfig = new SimpleTextReportConfiguration();

            // Increase page width to accommodate more characters per line
            reportConfig.setPageWidthInChars(180);
            reportConfig.setPageHeightInChars(30);

            // Adjust character width and height
            reportConfig.setCharWidth(5f);
            reportConfig.setCharHeight(0f);


            exporter.setConfiguration(reportConfig);


            // Export report to TXT
            exporter.exportReport();

            os.flush();
        }
    }

    @RequestMapping("/hkidgroupempty")
    public void generateReportGroupByEmptySpace(HttpServletResponse response) throws Exception {
        // Fetch data from database
        Resource resource = new ClassPathResource("templates/test2.jasper");

        try (FileInputStream is = new FileInputStream(resource.getFile());
             ServletOutputStream os = response.getOutputStream()) {

            List<HKIDRecord> hkidRecordList = sqlSession.selectList("site.zhourui.jasperreportdemo.mapper.TagMapper.selectAll");
            //sort the hkidRecordList by type
            Collections.sort(hkidRecordList, Comparator.comparing(HKIDRecord::getType));

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(hkidRecordList);

            response.setContentType("text/plain");
            response.setHeader("Content-Disposition", "attachment; filename=report.txt");

            // Create JasperPrint object and fill report
            JasperPrint jasperPrint = JasperFillManager.fillReport(is, null, dataSource);

            // Create text exporter
            JRTextExporter exporter = new JRTextExporter();



            // Configure exporter
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleWriterExporterOutput(os));


            SimpleTextReportConfiguration reportConfig = new SimpleTextReportConfiguration();

            // Increase page width to accommodate more characters per line
            reportConfig.setPageWidthInChars(180);
            reportConfig.setPageHeightInChars(60);

            // Adjust character width and height
            reportConfig.setCharWidth(5f);
            reportConfig.setCharHeight(0f);


            exporter.setConfiguration(reportConfig);


            // Export report to TXT
            exporter.exportReport();

            os.flush();
        }
    }




    private List<PledgeRecord> generateTestPledgeRecords() {
        List<PledgeRecord> records = new ArrayList<>();

        PledgeRecord record1 = new PledgeRecord();
        record1.setName("John Doe");
        record1.setEmail("john.doe@example.com");
        record1.setPledgeType(1L);
        record1.setAmount(new BigDecimal("100.00"));
        records.add(record1);

        PledgeRecord record3 = new PledgeRecord();
        record3.setName("Bob Johnson");
        record3.setEmail("bob.johnson@example.com");
        record3.setPledgeType(1L);
        record3.setAmount(new BigDecimal("75.25"));
        records.add(record3);

        PledgeRecord record2 = new PledgeRecord();
        record2.setName("Jane Smith");
        record2.setEmail("jane.smith@example.com");
        record2.setPledgeType(1L);
        record2.setAmount(new BigDecimal("250.50"));
        records.add(record2);



        PledgeRecord record4 = new PledgeRecord();
        record4.setName("Alice Brown");
        record4.setEmail("alice.brown@example.com");
        record4.setPledgeType(3L);
        record4.setAmount(new BigDecimal("500.00"));
        records.add(record4);

        PledgeRecord record5 = new PledgeRecord();
        record5.setName("Charlie Wilson");
        record5.setEmail("charlie.wilson@example.com");
        record5.setPledgeType(2L);
        record5.setAmount(new BigDecimal("150.75"));
        records.add(record5);

        return records;
    }

}
