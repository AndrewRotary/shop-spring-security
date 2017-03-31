package com.shop.repository;

import com.shop.Model.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by student on 3/27/2017.
 */
@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long>{

}
