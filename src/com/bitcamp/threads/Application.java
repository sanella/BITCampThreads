package com.bitcamp.threads;

import java.io.File;

public class Application {

	private static final String saveFilePath = "/tmp/crawled/";
	private static File outputDirectory = new File(saveFilePath);
	
	public static void main(String[] args) {

		String[] urls = new String[5];
		urls[0] = "http://klix.ba";
		urls[1] = "http://radiosarajevo.ba";
		urls[2] = "http://theverge.com";
		urls[3] = "http://market.ba";
		urls[4] = "http://lifehacker.com";

		
		
		if (!outputDirectory.exists()) {
			System.out.println("Crawler's output directory doesn't exist.");
			outputDirectory.mkdir();
			System.out.println("Crawler's output directory has been created.");
		}
		
		for (int i = 0; i < urls.length; i++) {

			if (urls[i] != null) {
				if (i % 2 == 0) {
					BitThreadExtends bitThreadExtends = new BitThreadExtends(
							"THREAD_EXTENDS_" + new Integer(i).toString(),
							urls[i]);
					bitThreadExtends.start();
				} else {
					BitThreadImplements bitThreadImplements = new BitThreadImplements(
							"THREAD_IMPLEMENTS_" + new Integer(i).toString(),
							urls[i]);
					Thread thread = new Thread(bitThreadImplements);
					thread.start();
				}
			}

		}

	}
}
