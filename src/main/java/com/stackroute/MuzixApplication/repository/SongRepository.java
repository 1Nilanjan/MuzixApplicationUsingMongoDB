package com.stackroute.MuzixApplication.repository;

import com.stackroute.MuzixApplication.domain.Muzix;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends MongoRepository<Muzix,Integer>
{
    //CRUD operations present in JpaRespository//

    public Muzix findBysongname(String name);
}
