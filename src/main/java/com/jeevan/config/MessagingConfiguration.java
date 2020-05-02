package com.jeevan.config;

import java.util.Arrays;

import javax.jms.ConnectionFactory;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class MessagingConfiguration
{

	private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616"; // we should not change this 
	private static final String MESSAGE_QUEUE = "message_queue"; //name

	@Bean
	public ConnectionFactory connectionFactory()
	{
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);// we need to set the url to send the data
		connectionFactory.setTrustedPackages(Arrays.asList("com.jeevan"));//add all packages which is used in send and receive Message object.
		return connectionFactory;
	}

	/*
	 * Used here for Sending Messages.
	 */
	@Bean
	public JmsTemplate jmsTemplate()
	{
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory());//jms template needs the connection factory
		template.setDefaultDestinationName(MESSAGE_QUEUE);  // queue name setting
		return template;
	}

}