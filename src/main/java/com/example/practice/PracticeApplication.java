package com.example.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
//		System.out.println("In the practice spring boot project");
//		int x = 5;
//		int y = 10;
//		System.out.println(x++ + ++y);

		List<String> list = List.of("test", "Hello", "tom");
		// ("t", "test")
		// H , Hello



		Map<Character, String> map = new HashMap<>();

		for(String s: list){
			Character c = s.charAt(0);
			if (map.get(c) == null){
				map.put(c, s);
			}
		}

		System.out.println(map);

	}

}
