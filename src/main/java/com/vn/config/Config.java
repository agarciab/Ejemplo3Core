package com.vn.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.vn.model.Framework;
import com.vn.model.ISoftware;
import com.vn.model.Tool;

@Configuration
@ComponentScan("com.vn")
@PropertySource({"framework.properties","tools.properties"})
public class Config {
	
	@Value("${alfresco.lookandfeel.value}")
	private int alfrescoLookAndFeel;
	
	@Value("${alfresco.friendliness.value}")
	private int alfrescoFriendliness;
	
	@Autowired
	private Environment env;
	
	@Bean
	@Primary
	public ISoftware prosa(@Value("${prosa.friendliness.value}") int friendliness, @Value("${prosa.robutness.value}") int robutness) {
		Framework prosa = new Framework();
		prosa.setName("Prosa");
		prosa.setFriendliness(friendliness);
		prosa.setRobutness(robutness);
		return prosa;
	}
	
	@Bean("apacheStruts")
	public ISoftware struts(@Value("${struts.friendliness.value}") int friendliness, @Value("${struts.robutness.value}") int robutness) {
		Framework struts = new Framework();
		struts.setName("Struts");
		struts.setFriendliness(friendliness);
		struts.setRobutness(robutness);
		return struts;
	}
	
	@Bean
	public ISoftware savia() {
		Tool savia = new Tool();
		savia.setName("Savia");
		savia.setFriendliness(Integer.valueOf(env.getProperty("savia.friendliness.value")));
		savia.setLookandfeel(Integer.valueOf(env.getProperty("savia.lookandfeel.value")));
		return savia;
	}
	
	@Bean
	@Qualifier("Gestor documental")
	public ISoftware alfresco() {
		Tool alfresco = new Tool();
		alfresco.setName("Alfresco");
		alfresco.setFriendliness(alfrescoFriendliness);
		alfresco.setLookandfeel(alfrescoLookAndFeel);
		return alfresco;
	}
	
	
	@Bean("software")
	public List<ISoftware> software(@Autowired ISoftware patata, @Autowired ISoftware apacheStruts, @Autowired ISoftware savia, @Autowired @Qualifier("Gestor documental") ISoftware bpm) {
		return Arrays.asList(patata, apacheStruts, savia, bpm);
	}
}
