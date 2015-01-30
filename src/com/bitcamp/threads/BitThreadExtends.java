package com.bitcamp.threads;

import java.net.MalformedURLException;

import com.bitcamp.threads.utils.Crawler;

public class BitThreadExtends extends Thread {

	private String name;
	private String url;

	public BitThreadExtends(String name, String url) {
		this.name = name;
		this.url = url;
	}

	public void run() {

		try {
			@SuppressWarnings("unused")
			Crawler crawler = new Crawler(url, name);
			Crawler.NUM_OF_CRAWLS_DONE++;
			System.out.println("NUM_OF_CRAWLS_DONE: "
					+ new Integer(Crawler.NUM_OF_CRAWLS_DONE).toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hello from a thread that extends Thread: " + name);
		System.out
				.println("------------------------------------------------------------");
	}
}
