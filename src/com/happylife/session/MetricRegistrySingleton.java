package com.happylife.session;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Slf4jReporter;
import com.codahale.metrics.ScheduledReporter.*;

public class MetricRegistrySingleton {
	public static final MetricRegistry metrics = new MetricRegistry();
	
	//Logger logger = Logger.getLogger(MetricRegistrySingleton.class.getName());
	Logger logger = LoggerFactory.getLogger(MetricRegistrySingleton.class.getName());
	Slf4jReporter reporter = Slf4jReporter.forRegistry(metrics)
										  .outputTo(logger)
										  .convertRatesTo(TimeUnit.SECONDS)
										  .convertDurationsTo(TimeUnit.MILLISECONDS)
										  .build();
	
	//reporter.start(5, TimeUnit.MINUTES);
	
}
