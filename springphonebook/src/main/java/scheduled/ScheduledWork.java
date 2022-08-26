package scheduled;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ScheduledWork {

	// @Scheduled(cron = "0/5 * * * * ?")
	public void work1() {
		System.out.println("5초마다 작업 실행");

	}

	// @Scheduled(cron = "0/10 * * * * ?")
	public void log() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("스케줄 실행 : " + dateFormat.format(calendar.getTime()));
	}

	// @Scheduled(cron = "0/5 * * * * ?")
	public void logger() {
		String name="test";
		log.debug("debug log={}", name);
		
	}
	
	// @Scheduled(cron = "0/5 * * * * ?")
	public void timelogger() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		log.debug("debug log={}", dateFormat.format(calendar.getTime()));
	}
}
