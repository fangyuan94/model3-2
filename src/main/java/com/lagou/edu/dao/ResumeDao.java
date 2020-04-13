package com.lagou.edu.dao;

import com.lagou.edu.pojo.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @@author fangyuan
 */
public interface ResumeDao extends JpaRepository<Resume,Long>,
        JpaSpecificationExecutor<Resume> {

}
