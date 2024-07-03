package site.zhourui.jasperreportdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"site.zhourui.jasperreportdemo"})
@MapperScan(basePackages = {"site.zhourui.jasperreportdemo.mapper"})
@EnableAsync
@EnableTransactionManagement
@EnableScheduling
public class JasperReportDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JasperReportDemoApplication.class, args);
    }

}
