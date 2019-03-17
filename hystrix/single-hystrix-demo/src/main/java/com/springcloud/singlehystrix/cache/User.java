package com.springcloud.singlehystrix.cache;

/**
 *
 * @author mr.yang
 * @date 2019/3/17
 */
public class User {
    private Integer userId;
    private String userName;
    private Long timeStamp;

    public User(Integer userId, String userName, Long timeStamp) {
        this.userId = userId;
        this.userName = userName;
        this.timeStamp = timeStamp;
    }

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", timestamp='" + timeStamp + '\'' +
                '}';
    }
}
