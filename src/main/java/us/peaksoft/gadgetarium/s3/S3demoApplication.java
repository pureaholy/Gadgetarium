package us.peaksoft.gadgetarium.s3;

import org.springframework.boot.SpringApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@org.springframework.boot.autoconfigure.SpringBootApplication
@EnableSwagger2
public class S3demoApplication {
    public static void main(String [] args){
        SpringApplication.run(S3demoApplication.class,args);
    }

}
