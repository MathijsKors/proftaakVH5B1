package nl.avans.facturatie.main;

import nl.avans.facturatie.config.ApplicationConfig;
import nl.avans.facturatie.config.ApplicationContext;
import nl.avans.facturatie.repository.DatabaseConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

import org.apache.catalina.Context;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


/**
 * Dit is een van de configuratiebestanden die vanuit de Application.java class worden
 * aangeroepen om je applicatie te initialiseren.
 *
 */
@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan(basePackages = {"nl.avans.facturatie"})
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        // Enable Application configuration. The followinng files will be used.
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ApplicationConfig.class);
        ctx.register(ApplicationContext.class);


        SpringApplication.run(Application.class);

        // Je kunt Bean uit de Ctx Context opvragen. Soms is dat nodig om bv een nieuw
        // object te kunnen maken - bv bij XYZRepository.
        // DriverManagerDataSource driverMgr = ctx.getBean(DriverManagerDataSource.class);
        // logger.info("Database driver URL = "+ driverMgr.getUrl() + " usernem = " + driverMgr.getUsername());
        
        
        //Database connection
        DatabaseConnection con = new DatabaseConnection( "jdbc:mysql://145.48.6.147/facturatie", "Facturatie", "Fac*turatie");
               
        
        
    }
    
    TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
        @Override
        protected void postProcessContext(Context context) {
            SecurityConstraint securityConstraint = new SecurityConstraint();
            securityConstraint.setUserConstraint("CONFIDENTIAL");
            SecurityCollection collection = new SecurityCollection();
            collection.addPattern("/*");
            securityConstraint.addCollection(collection);
            context.addConstraint(securityConstraint);
        }
    };

    @Bean
    public Java8TimeDialect java8TimeDialect() {
        return new Java8TimeDialect();
    }

}
