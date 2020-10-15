package com.ilona.listingparser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/listings")
public class ListingParserRestController {
	
	@Autowired
	private ListingParserService service;

	@GetMapping
	public String getListing(@RequestParam(required = false) Integer min_price, @RequestParam(required = false) Integer max_price,
							 @RequestParam(required = false) Integer min_bed, @RequestParam(required = false) Integer max_bed,
							 @RequestParam(required = false) Integer min_bath, @RequestParam(required = false) Integer max_bath) {
		return service.getListing(min_price, max_price, min_bed, max_bed, min_bath, max_bath);
	}
}
