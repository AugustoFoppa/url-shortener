package org.acme.infra;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

@Repository
public interface UrlRepositoryJpa extends CrudRepository<UrlEntity, Long> {

}
