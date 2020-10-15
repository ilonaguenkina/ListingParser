package com.ilona.listingparser;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ListingParserServiceImpl implements ListingParserService {

	private ListingRepository repository;
	
	@Autowired
	public ListingParserServiceImpl(ListingRepository repository) {
		this.repository = repository;
	}
	
	
	@Override
	public String getListing(Integer min_price, Integer max_price, Integer min_bed, Integer max_bed,
															   Integer min_bath, Integer max_bath) {
		Specification<ListingRow> predicate = null;
		if (min_price != null) {
			predicate = Specification.where(ListingSpecifications.minPrice(min_price));
		}
		
		if (max_price != null) {
			if (predicate != null) {
				predicate = predicate.and(ListingSpecifications.maxPrice(max_price));
			} else {
				predicate = ListingSpecifications.maxPrice(max_price);
			}
		}
		
		if (min_bed != null) {
			if (predicate != null) {
				predicate = predicate.and(ListingSpecifications.minBed(min_bed));
			} else {
				predicate = ListingSpecifications.minBed(min_bed);
			}
		}
		
		if (max_bed != null) {
			if (predicate != null) {
				predicate = predicate.and(ListingSpecifications.maxBed(max_bed));
			} else {
				predicate = ListingSpecifications.maxBed(max_bed);
			}
		}
		
		if (min_bath != null) {
			if (predicate != null) {
				predicate = predicate.and(ListingSpecifications.minBath(min_bath));
			} else {
				predicate = ListingSpecifications.minBath(min_bath);
			}
		}

		if (max_bath != null) {
			if (predicate != null) {
				predicate = predicate.and(ListingSpecifications.maxBath(max_bath));
			} else {
				predicate = ListingSpecifications.maxBath(max_bath);
			}
		}
		
		List<ListingRow> listings = predicate != null ? repository.findAll(predicate) : repository.findAll();
		return convertToGeoJSON(listings);
	}
	
	private String convertToGeoJSON(List<ListingRow> listings) {
		JSONObject result = new JSONObject();
		result.put("type", "FeatureCollection");
		JSONArray features = new JSONArray();
		result.put("features", features);
		for (ListingRow row : listings) {
			JSONObject feature = new JSONObject();
			feature.put("type", "Feature");
			
			JSONObject geometry = new JSONObject();
			geometry.put("type", "Point");
			JSONArray coordinates = new JSONArray();
			coordinates.put(row.getLat());
			coordinates.put(row.getLng());
			geometry.put("coordinates", coordinates);
			feature.put("geometry", geometry);
			
			JSONObject properties = new JSONObject();
			properties.put("id", row.getId());
			properties.put("price", row.getPrice());
			properties.put("street", row.getStreet());
			properties.put("bedrooms", row.getBedrooms());
			properties.put("bathrooms", row.getBathrooms());
			properties.put("sq_ft", row.getSqFt());
			feature.put("properties", properties);
			
			features.put(feature);
		}
		
		return result.toString();
	}

}
