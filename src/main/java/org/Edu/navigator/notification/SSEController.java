package org.Edu.navigator.notification;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.model.user.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.awt.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class SSEController {
    private final SSEService<User> sseService;

    @GetMapping(value = "Subscribe", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> subscribe() {
        return sseService.subscribe();
    }
}
