package spring.playground.proxy.app.v2.quartz;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Slf4j
//@Component
@RequiredArgsConstructor
public class AlarmDeleteByPolicyJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            log.info("==== alarm delete policy start ====");
//            alarmFeign.deleteAlarmListByPolicy();
        } catch (Exception e) {
            log.info("==== Failed to execute job ====");

            throw new JobExecutionException("Failed to execute job", e);
        }
    }

}
