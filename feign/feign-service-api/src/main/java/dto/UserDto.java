package dto;

import lombok.Data;

/**
 *
 * @author mr.yang
 * @date 2019/3/2
 */
@Data
public class UserDto {
    private Integer userId;
    private String userName;
    private String desc;

    @Override
    public String toString() {
        return "UserDto{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
