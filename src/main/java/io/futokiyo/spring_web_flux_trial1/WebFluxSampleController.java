package io.futokiyo.spring_web_flux_trial1;

import java.time.Duration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/fluxtest1")
public class WebFluxSampleController {

    @GetMapping("/flux_result")
    public Mono<String> getResult(ServerHttpRequest request) {
        System.out.println("AAAAA");
        return Mono.defer(() -> Mono.just("Result is ready!"))
                .delaySubscription(Duration.ofMillis(500));
    }

    @GetMapping("/aa/{delayMillis}")
    public Mono<String> getAa(@PathVariable int delayMillis){
        //Mono<String> justAa = Mono.just("aa");
        System.out.println("AA delayMillis:" + delayMillis);
        return Mono.defer(() -> Mono.just("Result is aa!"))
                .delaySubscription(Duration.ofMillis(delayMillis));
    }

    @GetMapping("/aiueo/{delayMillis}")
    public Flux<String> getAiueo(@PathVariable int delayMillis){
        Flux<String> aiueoJust = Flux.just("aiueo", "kakikukeko", "sashisuseso", "tatitsuteto");
        System.out.println("AIUEO delayMillis:" + delayMillis);
        return Flux.defer(() -> aiueoJust)
                .map(data -> "*" + data + "")
                .delaySubscription(Duration.ofMillis(delayMillis));
    }
}
