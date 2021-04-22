package cn.bjfu.engineerCertification.service;

import cn.bjfu.engineerCertification.entity.StudentInfo;
import cn.bjfu.engineerCertification.entity.UserInfo;
import cn.bjfu.engineerCertification.mapper.StudentMapper;
import cn.bjfu.engineerCertification.utils.ExcelUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jxy on 2021/4/22 0022 16:10
 */
@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public int addBatchStudentByExcel(InputStream in) throws Exception{
        XSSFWorkbook wookbook = new XSSFWorkbook(in);
        XSSFSheet sheet = wookbook.getSheet("Sheet1");
        // 获取到Excel文件中的所有行数
        int rows = sheet.getPhysicalNumberOfRows();
        List<StudentInfo> list = new ArrayList();
        for(int i =1;i<rows;i++){
            XSSFRow row = sheet.getRow(i);
            if(row != null){
                XSSFCell xssStudentId = row.getCell(1);
                String studentId = ExcelUtils.getValue(xssStudentId);
                XSSFCell xssstudentName = row.getCell(2);
                String userName = ExcelUtils.getValue(xssstudentName);
                XSSFCell xssProjectName = row.getCell(3);
                String projectName = ExcelUtils.getValue(xssProjectName);
                XSSFCell cellScore = row.getCell(4);
                String score = ExcelUtils.getValue(cellScore);
                StudentInfo.builder()
                        .studentId(Long.parseLong(studentId))
                        .studentName(userName)
                        .projectName(projectName)
                        .score(Double.parseDouble(score))
                        .build();
                //todo 插入数据库
            }
        }
        return 0;
    }
}
