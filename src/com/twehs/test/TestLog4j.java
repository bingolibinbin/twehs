package com.twehs.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestLog4j {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 PropertyConfigurator.configure( " log4j.properties " );
	     Logger logger  =  Logger.getLogger(TestLog4j.class );
         logger.debug( " debug " );
         logger.error( " error " );

	}

}
