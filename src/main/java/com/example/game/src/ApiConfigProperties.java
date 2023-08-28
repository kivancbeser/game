package com.example.game.src;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "api")
public class ApiConfigProperties {
    private String baseUrl;
    private String gameActivityPath;
    private int page;
    private int pageSize;

    // Getters and setters

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getGameActivityPath() {
        return gameActivityPath;
    }

    public void setGameActivityPath(String gameActivityPath) {
        this.gameActivityPath = gameActivityPath;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
