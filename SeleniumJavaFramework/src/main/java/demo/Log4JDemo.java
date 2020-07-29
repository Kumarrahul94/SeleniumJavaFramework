package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4JDemo {
	
		private static Logger logger = LogManager.getLogger(Log4JDemo.class);
		
		public static void main(String[] args) {
			System.out.println("\n    Hello World......    \n");
		
			logger.trace("This is trace message");
			logger.info("This is information message");
			logger.error("This is an error message");
			logger.warn("This is an warn message");
			logger.fatal("This is an fatal message");
			
		System.out.println("\n Completed");
		
	}

}
