package com.shop.repository;

import com.shop.Model.Item;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 3/27/2017.
 */
public interface ItemRepository extends CrudRepository<Item, Long> {
}
