package com.prashanth.flight.repository;

import com.prashanth.flight.model.SelectedTableRow;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SelectedTableRowRepository extends MongoRepository<SelectedTableRow,String> {
}
