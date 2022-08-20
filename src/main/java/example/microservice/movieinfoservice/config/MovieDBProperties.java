package example.microservice.movieinfoservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "moviedb.api")
public class MovieDBProperties {

    private String url;
    private int version;
    private String key;

    public MovieDBProperties() {
    }

    public MovieDBProperties(String url, int version, String key) {
        this.url = url;
        this.version = version;
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
