package com.vn.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vn.config.Config;
import com.vn.model.AssuranceQualifier;

public class MainSpring {

	public static void main(String[] args) {
		// Crear context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(Config.class);
		context.refresh();
		
		// Recuperar el bean
		AssuranceQualifier aq = context.getBean(AssuranceQualifier.class);
		
		// Usar el bean
		System.out.println(aq.getQualityAssurance());
		
		// Tancar context
		context.close();
	}

}
