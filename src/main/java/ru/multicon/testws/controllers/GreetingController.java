package ru.multicon.testws.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import ru.multicon.testws.domain.Greeting;
import ru.multicon.testws.domain.HelloMessage;

@Controller
public class GreetingController {

    // аннотация гарантирует, что если сообщение отправляется на /hello_hi, то будет вызван greeting() метод.
    @MessageMapping("/hello")
    // Возвращаемое значение рассылается всем подписчикам на /topic/greetings
    @SendTo("/topic/greetings")
    public Greeting greetings(HelloMessage message) throws Exception {

        return new Greeting("Hello, " + message.getName() + "!");

    }
}
