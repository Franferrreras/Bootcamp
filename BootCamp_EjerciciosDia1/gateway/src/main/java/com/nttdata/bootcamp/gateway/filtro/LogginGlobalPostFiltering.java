package com.nttdata.bootcamp.gateway.filtro;

import org.apache.log4j.Logger;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Mono;

@Configuration
public class LogginGlobalPostFiltering {

	private static Logger log = Logger.getLogger(LogginGlobalPreFilter.class);
	
	@Bean
	public GlobalFilter postGlobalFilter() {
		
		return (exchange, chain) -> {
			return chain.filter(exchange)
					.then(Mono.fromRunnable(() -> {
				log.info("Global Post Filter executed");
			}));
		};
	}
}
