package com.example.student.config;

import com.example.student.config.mySQL.MySqlConfiguration;
import com.example.student.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@org.springframework.context.annotation.Configuration
@Import({MySqlConfiguration.class})
public class Configuration {
}
