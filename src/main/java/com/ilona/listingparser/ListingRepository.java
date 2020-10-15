package com.ilona.listingparser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ListingRepository extends JpaRepository<ListingRow, String>, JpaSpecificationExecutor<ListingRow> {

}