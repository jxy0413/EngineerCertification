package cn.bjfu.engineerCertification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by jxy on 2021/4/19 0019 16:43
 */
@EnableSwagger2
@SpringBootApplication
public class EngineerCertificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(EngineerCertificationApplication.class, args);
    }
}
