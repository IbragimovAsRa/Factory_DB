package com.api.restapifactorydatabase;

import com.api.restapifactorydatabase.service.Impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiFactoryDataBaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestApiFactoryDataBaseApplication.class, args);
    }
}
