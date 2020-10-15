package com.ilona.listingparser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {
	@Autowired
    private ListingRepository repository;
	
	@Value("${csv.url}")
	private String csvUrl;

    @PostConstruct
    public void loadData() {
    	try {
	    	URL urlCSV = new URL(csvUrl);
	        URLConnection urlConn = urlCSV.openConnection();
	        InputStreamReader inputCSV = new InputStreamReader(((URLConnection) urlConn).getInputStream());
	        BufferedReader br = new BufferedReader(inputCSV);
	        String line = br.readLine();
	        while ((line = br.readLine()) != null) {
	        	String[] values = line.split(",");
	        	ListingRow row = new ListingRow(values[0], values[1], values[2], Integer.parseInt(values[3]),
	        									Integer.parseInt(values[4]), Integer.parseInt(values[5]),
	        									Integer.parseInt(values[6]), Float.parseFloat(values[7]),
	        									Float.parseFloat(values[8]));
	        	repository.save(row);
	        }
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    @PreDestroy
    public void removeData() {
    	repository.deleteAll();
    }
}
