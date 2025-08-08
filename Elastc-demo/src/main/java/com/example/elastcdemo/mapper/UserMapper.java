package com.example.elastcdemo.mapper;

import com.example.elastcdemo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends ElasticsearchRepository<User,String> {

    List<User> findByAddressLikeIgnoreCaseOrderByAgeDesc(String address);

    Page<User> findByUsernameContaining(String username, Pageable page);

    User findByAge(Integer age);

    List<User> findByGender(String gender);

    long count();

    Boolean existsById();

}
