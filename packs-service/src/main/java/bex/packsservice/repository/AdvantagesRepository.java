package bex.packsservice.repository;

import bex.packsservice.models.Advantage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvantagesRepository extends JpaRepository<Advantage, String> {
}
