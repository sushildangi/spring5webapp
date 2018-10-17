package org.pyarts.spring5webapp.repositories;

import org.pyarts.spring5webapp.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher,Long> {
}
