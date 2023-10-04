package com.testing.measureconverter;

import com.testing.measureconverter.Measures.Grades;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MeasureConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeasureConverterApplication.class, args);
		Grades grades = new Grades("7");
		String convertedToAmerican = grades.convertToAmerican();

		System.out.println("Danish to American: " + convertedToAmerican);
	}

}
