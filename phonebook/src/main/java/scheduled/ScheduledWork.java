package scheduled;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

// @Component
public class ScheduledWork {

	// @Scheduled(cron = "0/5 * * * * ?")
	public void timelogger() {
		final Logger log = Logger.getLogger(ScheduledWork.class);
		PropertyConfigurator.configure("C:\\Users\\Rysdne\\Desktop\\Rysdne\\Document\\01. Java\\work\\phonebook\\src\\main\\java\\scheduled\\log4j.properties");
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		log.debug(dateFormat.format(calendar.getTime()));
	}
}
