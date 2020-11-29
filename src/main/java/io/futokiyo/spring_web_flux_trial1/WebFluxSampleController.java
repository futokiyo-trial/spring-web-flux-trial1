package io.futokiyo.spring_web_flux_trial1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.ParallelFlux;
import reactor.core.scheduler.Schedulers;

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

    @GetMapping(value = "/aiueo2", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public ParallelFlux<String> getAiueo2(){
        List<String> aiueoList = new ArrayList<>();
        aiueoList.add("aiueo");
        aiueoList.add("kakikukeko");
        aiueoList.add("sashisuseso");
        aiueoList.add("tatitsuteto");
        aiueoList.add("naninuneno");
        aiueoList.add("hahihuheho");
        aiueoList.add("mamimumemo");
        aiueoList.add("yayiyuyeyo");
        aiueoList.add("wawiwuwewo");
        aiueoList.add("gagigugego");
        ParallelFlux<String> aiueoParallelFlux = Flux
                .interval(Duration.ofSeconds(6))
                .take(10)
                .parallel(2)
                .runOn(Schedulers.parallel())
                .map(idx -> {
                    System.out.println( idx + " : " + aiueoList.get(idx.intValue()) + ": Current Thread ID- " + Thread.currentThread().getId() + " For Thread- " + Thread.currentThread().getName() );
                    return aiueoList.get(idx.intValue());
                } );
        System.out.println("aiueoParallelFlux " );
        return aiueoParallelFlux;
    }
}
