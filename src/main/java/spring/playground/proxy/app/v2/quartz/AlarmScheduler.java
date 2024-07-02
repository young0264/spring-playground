package spring.playground.proxy.app.v2.quartz;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

@Slf4j
@Component
public class AlarmScheduler {

    private Scheduler scheduler;
    private SchedulerFactory schedulerFactory;

//    @Autowired
//    private Scheduler scheduler;

    @PostConstruct
    public void start() throws SchedulerException {
        log.info("==== alarmDeleteScheduleJob start ====");

        JobDetail alarmDeleteJob = JobBuilder.newJob(AlarmDeleteByPolicyJob.class)
                .withIdentity("alarmDeleteJob", "alarmDeleteGroup")
                .storeDurably(true)
                .build();

        /** calendar 시간 설정 2 */
        SimpleTrigger trigger2 = TriggerBuilder.newTrigger()
                .withIdentity("alarmDeleteTrigger", "alarmDeleteTriggerGroup")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(3)
                        .repeatForever())
                .build();

        schedulerFactory = new StdSchedulerFactory();
        scheduler = schedulerFactory.getScheduler();

        scheduler.start();

        scheduler.scheduleJob(alarmDeleteJob, trigger2);

    }
}
