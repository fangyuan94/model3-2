package com.lagou.edu.service.impl;

import com.lagou.edu.dao.ResumeDao;
import com.lagou.edu.pojo.Resume;
import com.lagou.edu.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeDao resumeDao;

    @Override
    public List<Resume> queryResumeList() throws Exception {
        return resumeDao.findAll();
    }

    @Override
    public void addNewResume(Resume resume) throws Exception {
        resumeDao.save(resume);
    }

    @Override
    public void delResume(Long id) throws Exception {
        resumeDao.deleteById(id);
    }

    @Override
    public void updateResume(Resume resume) {
        resumeDao.save(resume);

    }
}
