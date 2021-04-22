package cn.bjfu.engineerCertification.entity;

import lombok.*;

/**
 * Created by jxy on 2021/4/22 0022 16:17
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentInfo {
    private Long studentId;
    private String studentName;
    private String projectName;
    private Double score;
}
