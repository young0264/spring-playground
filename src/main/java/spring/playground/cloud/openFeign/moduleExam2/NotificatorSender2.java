package spring.playground.cloud.openFeign.moduleExam2;//
//package org.okestro.tps.notificator.infrastructure.components;
//
//import org.okestro.tps.common_lib.infrastructure.client.IntegrationClientWithNotificator;
//import org.okestro.tps.common_lib.message.TpsResponse;
//import org.okestro.tps.common_lib.message.alarmModel.dto.AllClientsAlarmDto;
//import org.okestro.tps.common_lib.message.alarmModel.dto.SpecificClientsAlarmDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//
///**
// * NotificatorSender
// */
//@Component
//public class NotificatorSender {
//
//    @Autowired
//    private IntegrationClientWithNotificator integrationClientWithNotificator;
//
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
//
//    public ResponseEntity<?> getTest(){
//        return integrationClientWithNotificator.getTest();
//    }
//
//
//}
