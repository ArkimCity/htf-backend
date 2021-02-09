package htf.backend.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FireAlarm {
	public static void main(String[] args) {
//		fireAlarm();
		//measure 중에 온도에 해당하는 걸 찾아 그게 ex)50도 이상이 지속되면 그 meaure에 해당하는 기계에 해당하는 멤버에 해당하는 관리자를 관리자로 두는 모든 멤버를 소환하면 되겠다.
		//알림 관련해서 구독 만료도 가능
		
	}
	
	public static void fireAlarm() {
		int sleepSec = 3; // 실행간격
		final SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");
		final ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);

		exec.scheduleAtFixedRate(new Runnable() {
			public void run() {
				try {
					Calendar cal = Calendar.getInstance();
					// 콘솔에 현재 시간 출력
					System.out.println(fmt.format(cal.getTime()));
				} catch (Exception e) {
					e.printStackTrace();
					// 에러 발생시 Executor를 중지시킨다
					exec.shutdown();
				}
			}
		}, 0, sleepSec, TimeUnit.SECONDS);
	}
}
