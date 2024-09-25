package org.Edu.navigator.notification;



import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Service
public class SSEService<T> {
    private final Sinks.Many<T> sink = Sinks.many().multicast().onBackpressureBuffer();

    public Flux<T> subscribe() {
        return sink.asFlux();
    }

    public void emit(T data) {
        sink.tryEmitNext(data);
    }
}