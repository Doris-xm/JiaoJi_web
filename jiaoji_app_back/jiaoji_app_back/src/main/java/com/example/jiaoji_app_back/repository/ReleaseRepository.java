package com.example.jiaoji_app_back.repository;

import com.example.jiaoji_app_back.entity.ActivityRelease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReleaseRepository extends JpaRepository<ActivityRelease,Integer> {
    List<ActivityRelease> findActivityReleaseByUserId(Integer userId);
}
