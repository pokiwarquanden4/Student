package com.example.student.config;

import com.example.student.config.mySQL.MySqlConfiguration;
import org.springframework.context.annotation.Import;

@org.springframework.context.annotation.Configuration
@Import({MySqlConfiguration.class})
public class Configuration {

}
