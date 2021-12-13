package br.com.erudio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.erudio.data.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Modifying
    @Query("update Person p set p.enabled = false where p.id = :id")
    void disablePerson(@Param("id") Long id);
}