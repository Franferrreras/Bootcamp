package com.nttdata.bootcamp.gateway.filtro;

import org.apache.log4j.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class LogginGlobalPreFilter implements GlobalFilter {

	private static Logger log = Logger.getLogger(LogginGlobalPreFilter.class);
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		// TODO Auto-generated method stub
		log.info("Global prefilter executed");
		return chain.filter(exchange);
	}

}
