package spring.playground.cloud.openFeign.moduleExam1;


import feign.Feign;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import spring.playground.cloud.openFeign.IntegrationClientWithNotificator;

/**
 * NotificatorSender
 */
@Component
public class NotificatorSender1 {

    @Value("${notificator.url}")
    private String requestUrl;

    IntegrationClientWithNotificator integrationClientWithNotificator;

//    @Autowired
//    public NotificatorSender1() {
//    }
    @PostConstruct
    public void init() {
        //TODO configuration 동적 설정하는 방법이 있는지 찾아보기.
        //TODO ㄴ 멀티모듈 환경일 때 각 모듈에서 configuration을 하고 싶음.
        integrationClientWithNotificator = Feign.builder()
                .target(IntegrationClientWithNotificator.class, requestUrl);
    }


//    public TpsResponse<?> sendSSEToAllClients(@RequestBody AllClientsAlarmDto alarmDto){
//        return integrationClientWithNotificator.sendSSEToAllClients(alarmDto);
//    }
//
//    /**
//     * 일부 유저에게만 알림을 보낼 때
//     */
//    public TpsResponse<?> sendSSEToSpecificClients(@RequestBody SpecificClientsAlarmDto alarmDto){
//        return integrationClientWithNotificator.sendSSEToSpecificClients(alarmDto);
//    }
//



}
