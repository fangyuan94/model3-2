package com.lagou.edu.service;

import com.lagou.edu.pojo.Resume;

import java.util.List;

public interface ResumeService {

    List<Resume> queryResumeList() throws Exception;

    void addNewResume(Resume resume)throws Exception;

    void delResume(Long id)throws Exception;

    void updateResume(Resume resume);
}
