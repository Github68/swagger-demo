package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collection;

@SpringBootApplication
@EnableSwagger2 
public class DocApplication extends SpringBootServletInitializer { //is the main class that loads the application

    public static void main(String[] args) {
        SpringApplication.run(DocApplication.class, args);
    }

    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(PathSelectors.any())
                .build()
                .enable(true)
                .apiInfo(apiInfo());
    }

    public ApiInfo apiInfo() {
        StringVendorExtension vendorExtension = new StringVendorExtension("", "");
        Collection<VendorExtension> vendorExtensions = new ArrayList<VendorExtension>();
        vendorExtensions.add(vendorExtension);

        Contact contactInfo = new Contact("AtechRef", "www.atechref.com",
                "atechsoft@gmail.com");

        return new ApiInfo(
                "SpringBoot-Swagger2-JaxRS",
                "Example project showing how to integrate spring boot " +
                        "web app using jaxrs instead of springmvc with swagger and springfox.",
                "1.0",
                "For Demo only",
                contactInfo,
                "Apache 2.0",
                "www.apache.org",
                vendorExtensions);
    }

}
