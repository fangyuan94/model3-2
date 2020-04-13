package com.lagou.edu.controller;

import com.lagou.edu.annotation.JsonRs;
import com.lagou.edu.pojo.Resume;
import com.lagou.edu.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @GetMapping("/queryAll")
    @JsonRs
    public List<Resume>  queryAll() throws Exception {
        return resumeService.queryResumeList();
    }

    @PostMapping("/addNewResume")
    @JsonRs
    public  void addNewResume(@RequestBody Resume resume) throws Exception {
         resumeService.addNewResume(resume);
    }

    @PostMapping("/delResume")
    @JsonRs
    public  void delResume(@RequestParam(value = "id",required = true) Long id) throws Exception {
        resumeService.delResume(id);
    }

    @PostMapping("/updateResume")
    @JsonRs
    public  void updateResume(@RequestBody Resume resume) throws Exception {
        resumeService.updateResume(resume);
    }


}
