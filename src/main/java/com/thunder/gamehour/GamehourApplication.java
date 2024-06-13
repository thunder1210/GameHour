package com.thunder.gamehour;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Springboot start Application
 */
@Slf4j
@EnableCaching
@SpringBootApplication
@RequiredArgsConstructor
public class GamehourApplication implements ApplicationRunner {

	private final JdbcTemplate jdbcTemplate;

	@Value("classpath:gameHour.sql")
	private Resource initDataScript;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(initDataScript.getInputStream()));
			StringBuilder stringBuilder = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append("\n");
			}
			reader.close();
			String sqlScript = stringBuilder.toString();
			jdbcTemplate.execute(sqlScript);
		} catch (Exception e) {
			log.info("{}" + initDataScript, e);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(GamehourApplication.class, args);
	}

}
