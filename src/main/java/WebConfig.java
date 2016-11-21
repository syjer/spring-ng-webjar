import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import ro.isdc.wro.http.ConfigurableWroFilter;

@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean("wroFilter")
    public ConfigurableWroFilter getWro4jFilter() {
        ConfigurableWroFilter filter = new ConfigurableWroFilter();

        //FIXME must be moved in property :)
        filter.setCacheUpdatePeriod(1);
        filter.setModelUpdatePeriod(1);
        filter.setDebug(true);
        filter.setDisableCache(true);
        return filter;
    }
}
