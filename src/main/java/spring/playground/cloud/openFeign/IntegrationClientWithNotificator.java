package spring.playground.cloud.openFeign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "integrationClientWithNotificator", url = "placeholder")
public interface IntegrationClientWithNotificator {

    /**
     * 모든 유저에게 알림을 보낼 때
     */
//    @PostMapping("/all")
//    CommonResponse<?> sendSSEToAllClients(@RequestBody AllClientsAlarmDto alarmDto);

    /**
     * 일부 유저에게만 알림을 보낼 때
     */
//    @PostMapping("/specific")
//    CommonResponse<?> sendSSEToSpecificClients(@RequestBody SpecificClientsAlarmDto alarmDto);

}