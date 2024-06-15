package spring.playground.cloud.openFeign.dynamicUrl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class FeignUsingService {

    private final AlarmClientWithNotificator alarmClientWithNotificator;
    private final FeignConfigEnv feignConfigEnv;

    public void usingFeignEachEnvExam() {
        String baseUrl = feignConfigEnv.getBaseUrl();
        log.info("============ feignConfig Env url ============ : " + baseUrl);
//        alarmClientWithNotificator.sendSSEToAllClients(baseUrl, allClientsAlarmDto);
    }

}
