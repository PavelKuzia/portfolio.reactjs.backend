package movie_trending.backend.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Initialization implements CommandLineRunner {
    @Value("${server.port}")
    private int serverPort;

    @Value("${ENV_STAGE}")
    private String stage;

    @Override
    public void run(String... args) throws Exception {
        System.out.printf("Server is running on port %d in %s mode\n", serverPort, stage);
    }
}
