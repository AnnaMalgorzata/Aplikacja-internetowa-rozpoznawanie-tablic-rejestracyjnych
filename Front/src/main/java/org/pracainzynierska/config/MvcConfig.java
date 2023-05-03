package org.pracainzynierska.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /*
        Najpierw konfigurujemy zewnętrzną ścieżkę URI, definiując handler zasobów.
        Następnie mapujemy wewnętrznie tę zewnętrzną ścieżkę URI na fizyczną ścieżkę,
        na której faktycznie znajdują się zasoby.
        Można oczywiście zdefiniować wiele handlerów zasobów używając tego prostego,
        ale elastycznego API.
        Teraz następująca linia na stronie html da nam zasób myCss.css wewnątrz katalogu webapp/resources:
            <link rel="stylesheet" th:href="@{css/main.css}"/>
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/static/**")) {
            registry.addResourceHandler("/static/**")
                    .addResourceLocations("/static/");
        }
    }
}