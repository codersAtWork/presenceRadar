package at.wagner.smarthome.presenceradar.server.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;

import at.wagner.smarthome.presenceradar.server.repository.PersonRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PresenceDetectionService {

	private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

	private final PersonRepository repository;

	@PostConstruct
	private void startDetection() {

		String tag = "7C:2F:80:97:0F:3F";
		String command = "http://192.168.26.10:8080/lockAction?nukiId=185328513&token=jrvpqL&action=";

		final AtomicBoolean away = new AtomicBoolean(true);

		Runnable task = new Runnable() {

			@Override
			public void run() {

				try {
					boolean found = scan();

					if (away.get() && found) {
						System.out.println("Found tag " + tag);

						away.set(false);
						sendCommand("1");
					} else if (!away.get() && !found) {
						System.out.println("Lost tag " + tag);

						away.set(true);
						sendCommand("2");
					}

				} catch (Exception e) {
					System.err.println(e);
				}
			}

			private boolean scan() throws Exception {
				boolean found = false;

				ProcessBuilder builder = new ProcessBuilder("sudo", "hcitool", "lecc", tag);
				Process process = builder.start();

				BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String line;
				while ((line = in.readLine()) != null) {
					if (line.contains("Connection handle")) {
						found = true;
					}
				}
				process.waitFor();
				in.close();

				return found;
			}

			private void sendCommand(String action) throws Exception {
				URL url = new URL(command + action);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.getResponseCode();
				conn.disconnect();
			}
		};
		executor.scheduleAtFixedRate(task, 5, 5, TimeUnit.SECONDS);

	}

	@PreDestroy
	public void stopDetection() {
		executor.shutdown();
	}

}
