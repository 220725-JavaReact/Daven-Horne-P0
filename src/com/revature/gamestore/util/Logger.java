package com.revature.gamestore.util;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Logger {
		//singleton design pattern
		// private instance
		private static Logger logger= new Logger();
		// private constructor
		private Logger() {
			
		}
		// getter for the only instance of the class
		public static Logger getLogger() {
			return logger;
		}
		private void writeToFile(String message) {
			// try with resources block - opens a resource then closes it once the code block finishes execution
			try (FileWriter writer = new FileWriter(LocalDate.now().toString()+".log", true)){
				writer.append(message+"\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// method overloading
		public void log(LogLevel logLevel, String message) {
			Log newLog = new Log(logLevel, LocalDateTime.now(), message);
			writeToFile(newLog.toString());
		}
		public void log(LogLevel logLevel, Exception ex) {
			Log newLog = new Log(logLevel, LocalDateTime.now(), ex.toString());
			writeToFile(newLog.toString());
		}
		private class Log{
			LogLevel logLevel; 
			LocalDateTime timestamp; 
			String message;
			
			public Log(LogLevel logLevel, LocalDateTime timestamp, String message) {
				super();
				this.logLevel = logLevel;
				this.timestamp = timestamp;
				this.message = message;
			}
			@Override
			public String toString() {
				return logLevel + "\t" + timestamp + "\t" + message ;
			}
			
		}
		//enum is a type that allows you to set constant values
		public enum LogLevel{
			info, debug, verbose, warning, fatal, error
		}

}
