package io.futokiyo.spring_web_flux_trial1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import org.springframework.boot.web.embedded.undertow.UndertowBuilderCustomizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.reactive.function.server.RouterFunction;
//import org.springframework.web.reactive.function.server.ServerRequest;
//import org.springframework.web.reactive.function.server.ServerResponse;
//import reactor.core.publisher.Mono;
//
//import static org.springframework.web.reactive.function.BodyInserters.fromObject;
//import static org.springframework.web.reactive.function.server.RouterFunctions.route;
//import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication
public class SpringWebFluxTrial1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebFluxTrial1Application.class, args);
	}



//	@Bean
//	public RouterFunction<ServerResponse> helloRouter() {
//		return route()
//				.GET("/hello", this::helloHandler)
//				.build();
//	}
//
//	private Mono<ServerResponse> helloHandler(ServerRequest request) {
//		String name = request
//				.queryParam("name")
//				.orElse("World");
//		String message = String.format("Hello, %s!", name);
//
//		return ok()
//				.body(fromObject(message));
//	}
}
