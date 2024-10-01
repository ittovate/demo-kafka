package com.example.kafkademo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.example.kafkademo.constant.SwaggerConstant.CONTACT_NAME;
import static com.example.kafkademo.constant.SwaggerConstant.CONTACT_URL;
import static com.example.kafkademo.constant.SwaggerConstant.DESCRIPTION;
import static com.example.kafkademo.constant.SwaggerConstant.TITLE;
import static com.example.kafkademo.constant.SwaggerConstant.VERSION;


@SpringBootApplication
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
@OpenAPIDefinition(info = @Info(title = TITLE, version = VERSION, description = DESCRIPTION,
        contact = @Contact(name = CONTACT_NAME, url = CONTACT_URL)
))
public class KafkaDemoApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoApplication.class, args);
    }

}
