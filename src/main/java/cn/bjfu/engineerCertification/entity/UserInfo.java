package cn.bjfu.engineerCertification.entity;

import lombok.*;

/**
 * Created by jxy on 2021/4/19 0019 17:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserInfo {
    private Integer userId;
    private String username;
    private String password;
}
