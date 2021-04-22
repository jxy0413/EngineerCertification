package cn.bjfu.engineerCertification.controller;


import cn.bjfu.engineerCertification.model.RetResult;
import cn.bjfu.engineerCertification.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by jxy on 2021/4/22 0022 16:10
 */
@RequestMapping("/student")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/addBatchStudentByExcel")
    public RetResult addBatchStudentByExcel(@RequestParam("file")MultipartFile file){
        int ret = 0;
        try {
            ret = studentService.addBatchStudentByExcel(file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(ret > 0){
            return RetResult.SUCCESS("导入学生数据成功");
        }else{
            return RetResult.ERROR();
        }
    }
}
