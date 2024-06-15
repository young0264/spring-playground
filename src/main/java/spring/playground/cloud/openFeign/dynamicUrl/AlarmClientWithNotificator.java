package spring.playground.cloud.openFeign.dynamicUrl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;

@FeignClient(name = "alarm-feign", url = "http://tps-notificator/notificator/api/sse/v1")
//@FeignClient(name = "alarm-feign", url = "http://tps-notificator/notificator/api/sse/v1", configuration = FeignConfigGlobal.class)
public interface AlarmClientWithNotificator {

    /**
     * 모든 유저에게 알림을 보낼 때
     */
//    @PostMapping("/all")
//    TpsResponse<?> sendSSEToAllClients(URI baseUrl, @RequestBody AllClientsAlarmDto alarmDto);

    /**
     * 일부 유저에게만 알림을 보낼 때
     */
//    @PostMapping("/specific")
//    TpsResponse<?> sendSSEToSpecificClients(@RequestBody SpecificClientsAlarmDto alarmDto);

    @GetMapping(value = "/all")
    ResponseEntity<?> getTest();


}
