package spring.playground.basic.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메시지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    //서비스 종료시 호출
    public void disConnect() {
        System.out.println("close: " + url);
    }

    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    public void close() {
        System.out.println("NetworkClient.close");
        disConnect();
    }

//    @Override
//    public void destroy() throws Exception {
//        disconnect();
//    }
//
//    @Override // bean이 초기화 되고 실행
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("afterPropertiesSet start");
//        connect();
//        call("초기화 연결 메시지입니다.");
//        System.out.println("afterPropertiesSet end");
//    }



}

