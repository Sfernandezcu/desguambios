package com.dsg.desguambios;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;


@EnableCaching
@SpringBootApplication
public class DesguambiosApplication {
	
	private static final Log LOG = LogFactory.getLog(DesguambiosApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DesguambiosApplication.class, args);
	}
	
	@Bean
    public CacheManager cacheManager() {
    	LOG.info("Activating cache...");
    	return new ConcurrentMapCacheManager("favoritos");
    }
	
}
