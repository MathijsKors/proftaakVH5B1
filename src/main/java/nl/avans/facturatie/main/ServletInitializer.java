package nl.avans.facturatie.main;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 *
 * @author Gebruiker
 */
public class ServletInitializer extends SpringBootServletInitializer {

    /**
     *
     * @param application
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
