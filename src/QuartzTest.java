import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
public class QuartzTest{
    public void task() throws SchedulerException
    {
        // Initiate a Schedule Factory
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        // Retrieve a scheduler from schedule factory
        Scheduler scheduler = schedulerFactory.getScheduler();
        
        String[] triggerGroups;
        String[] triggers;

        triggerGroups = scheduler.getTriggerGroupNames();
        for (int i = 0; i < triggerGroups.length; i++) {
           triggers = scheduler.getTriggerNames(triggerGroups[i]);
           for (int j = 0; j < triggers.length; j++) {
              Trigger tg = scheduler.getTrigger(triggers[j], triggerGroups[i]);
              
              if (tg instanceof SimpleTrigger && tg.getName().equals("simpleTrigger")) {
                  ((SimpleTrigger)tg).setRepeatCount(100);
                  // reschedule the job
                  scheduler.rescheduleJob(triggers[j], triggerGroups[i], tg);
                  // unschedule the job
                  //scheduler.unscheduleJob(triggersInGroup[j], triggerGroups[i]);
              }
           }
        }        

        // start the scheduler
        scheduler.start();
        
        
    }  



}