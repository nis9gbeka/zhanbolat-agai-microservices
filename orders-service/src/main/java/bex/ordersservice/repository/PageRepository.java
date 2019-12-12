package bex.ordersservice.repository;

import bex.ordersservice.models.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends JpaRepository<Page, String> {
    Page findByUrl(String url);
}
