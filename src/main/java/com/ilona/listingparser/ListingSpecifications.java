package com.ilona.listingparser;

import org.springframework.data.jpa.domain.Specification;

public class ListingSpecifications {
	
	static Specification<ListingRow> minPrice(int minPrice) {
	    return (row, cq, cb) -> cb.greaterThanOrEqualTo(row.get("price"), minPrice);
	}
	
	static Specification<ListingRow> maxPrice(int maxPrice) {
	    return (row, cq, cb) -> cb.lessThanOrEqualTo(row.get("price"), maxPrice);
	}
	
	static Specification<ListingRow> minBed(int minBed) {
	    return (row, cq, cb) -> cb.greaterThanOrEqualTo(row.get("bedrooms"), minBed);
	}
	
	static Specification<ListingRow> maxBed(int maxBed) {
	    return (row, cq, cb) -> cb.lessThanOrEqualTo(row.get("bedrooms"), maxBed);
	}
	
	static Specification<ListingRow> minBath(int minBath) {
	    return (row, cq, cb) -> cb.greaterThanOrEqualTo(row.get("bathrooms"), minBath);
	}
	
	static Specification<ListingRow> maxBath(int maxBath) {
	    return (row, cq, cb) -> cb.lessThanOrEqualTo(row.get("bathrooms"), maxBath);
	}
}
