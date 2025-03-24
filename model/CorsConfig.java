@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins("*")  // Permite qualquer origem (melhor restringir depois)
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}
