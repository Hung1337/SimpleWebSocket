package me.hung.simplewebsocket.controller;

import me.hung.simplewebsocket.entity.MessageEntity;
import me.hung.simplewebsocket.entity.ResponseMessageEntity;
import me.hung.simplewebsocket.entity.WSSession;
import me.hung.simplewebsocket.service.MessageService;
import me.hung.simplewebsocket.service.SocketPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Danila Avdeyenko
 * @date 09.06.2022 | 7:06
 */


@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private SocketPoolService socketPoolService;

    @Autowired
    private MessageService messageService;

    @GetMapping("/sessions")
    public List<WSSession> getActiveSessions() {
        return socketPoolService.getWSSessions();
    }

    @PostMapping("/send/session/{sessionId}")
    public ResponseEntity<?> sendMessageBySessionId(@PathVariable String sessionId,
                                                    @RequestBody MessageEntity message) {

//        java.lang.NullPointerException: null
//        at java.base/java.util.Optional.orElseGet(Optional.java:369) ~[na:na]
//        at me.hung.simplewebsocket.service.SocketPoolService.getSessionById(SocketPoolService.java:38) ~[classes/:na]
//        at me.hung.simplewebsocket.service.MessageService.sendMessageBySession(MessageService.java:36) ~[classes/:na]
//        at me.hung.simplewebsocket.controller.NotificationController.sendMessageBySessionId(NotificationController.java:39) ~[classes/:na]
//        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
//        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:na]
//        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
//        at java.base/java.lang.reflect.Method.invoke(Method.java:566) ~[na:na]
//        at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:205) ~[spring-web-5.3.20.jar:5.3.20]
//        at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:150) ~[spring-web-5.3.20.jar:5.3.20]
//        at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:117) ~[spring-webmvc-5.3.20.jar:5.3.20]
//        at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:895) ~[spring-webmvc-5.3.20.jar:5.3.20]
//        at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808) ~[spring-webmvc-5.3.20.jar:5.3.20]
//        at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87) ~[spring-webmvc-5.3.20.jar:5.3.20]
//        at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1067) ~[spring-webmvc-5.3.20.jar:5.3.20]
//        at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:963) ~[spring-webmvc-5.3.20.jar:5.3.20]
//        at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006) ~[spring-webmvc-5.3.20.jar:5.3.20]
//        at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:909) ~[spring-webmvc-5.3.20.jar:5.3.20]
//        at javax.servlet.http.HttpServlet.service(HttpServlet.java:681) ~[tomcat-embed-core-9.0.63.jar:4.0.FR]
//        at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883) ~[spring-webmvc-5.3.20.jar:5.3.20]
//        at javax.servlet.http.HttpServlet.service(HttpServlet.java:764) ~[tomcat-embed-core-9.0.63.jar:4.0.FR]
//        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:227) ~[tomcat-embed-core-9.0.63.jar:9.0.63]
//        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.63.jar:9.0.63]
//        at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53) ~[tomcat-embed-websocket-9.0.63.jar:9.0.63]
//        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.63.jar:9.0.63]
//        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.63.jar:9.0.63]
//        at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100) ~[spring-web-5.3.20.jar:5.3.20]
//        at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) ~[spring-web-5.3.20.jar:5.3.20]
//        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.63.jar:9.0.63]
//        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.63.jar:9.0.63]
//        at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93) ~[spring-web-5.3.20.jar:5.3.20]
//        at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) ~[spring-web-5.3.20.jar:5.3.20]
//        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.63.jar:9.0.63]
//        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.63.jar:9.0.63]
//        at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201) ~[spring-web-5.3.20.jar:5.3.20]
//        at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) ~[spring-web-5.3.20.jar:5.3.20]
//        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.63.jar:9.0.63]
//        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.63.jar:9.0.63]
//        at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:197) ~[tomcat-embed-core-9.0.63.jar:9.0.63]
//        at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:97) ~[tomcat-embed-core-9.0.63.jar:9.0.63]
//        at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:541) ~[tomcat-embed-core-9.0.63.jar:9.0.63]
//        at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:135) ~[tomcat-embed-core-9.0.63.jar:9.0.63]
//        at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92) ~[tomcat-embed-core-9.0.63.jar:9.0.63]
//        at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:78) ~[tomcat-embed-core-9.0.63.jar:9.0.63]
//        at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:360) ~[tomcat-embed-core-9.0.63.jar:9.0.63]
//        at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:399) ~[tomcat-embed-core-9.0.63.jar:9.0.63]
//        at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65) ~[tomcat-embed-core-9.0.63.jar:9.0.63]
//        at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:890) ~[tomcat-embed-core-9.0.63.jar:9.0.63]
//        at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1743) ~[tomcat-embed-core-9.0.63.jar:9.0.63]
//        at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49) ~[tomcat-embed-core-9.0.63.jar:9.0.63]
//        at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191) ~[tomcat-embed-core-9.0.63.jar:9.0.63]
//        at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659) ~[tomcat-embed-core-9.0.63.jar:9.0.63]
//        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) ~[tomcat-embed-core-9.0.63.jar:9.0.63]
//        at java.base/java.lang.Thread.run(Thread.java:829) ~[na:na]

        boolean sent = false;//messageService.sendMessageBySession(sessionId, message);
        if (sent) {
            return ResponseEntity
                    .status(200)
                    .body(new ResponseMessageEntity("Уведомление отправлено!"));
        }

        return ResponseEntity
                .status(500)
                .body(new ResponseMessageEntity("Произошла ошибка. Скорее всего, сессия уже не жива."));

    }

    @PostMapping("/send/username/{username}")
    public ResponseEntity<?> sendMessageByUsername(@PathVariable String username,
                                                   @RequestBody MessageEntity message) {
        boolean sent = false;//messageService.sendMessageByUsername(username, message);
        if (sent) {
            return ResponseEntity
                    .status(200)
                    .body(new ResponseMessageEntity("Уведомление отправлено!"));
        }

        return ResponseEntity
                .status(500)
                .body(new ResponseMessageEntity("Произошла ошибка. Скорее всего, сессия уже не жива."));
    }

}
