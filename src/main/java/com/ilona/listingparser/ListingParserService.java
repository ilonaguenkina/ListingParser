package com.ilona.listingparser;

public interface ListingParserService {
	public String getListing(Integer min_price, Integer max_price, Integer min_bed, Integer max_bed,
																Integer min_bath, Integer max_bath);
}
