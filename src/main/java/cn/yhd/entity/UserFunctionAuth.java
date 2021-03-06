package cn.yhd.entity;

import java.util.Date;

public class UserFunctionAuth extends UserFunctionAuthKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_function_auth.unban_time
     *
     * @mbggenerated
     */
    private Date unbanTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_function_auth.reason
     *
     * @mbggenerated
     */
    private String reason;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_function_auth.created_time
     *
     * @mbggenerated
     */
    private Date createdTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_function_auth.modified_time
     *
     * @mbggenerated
     */
    private Date modifiedTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_function_auth.unban_time
     *
     * @return the value of user_function_auth.unban_time
     *
     * @mbggenerated
     */
    public Date getUnbanTime() {
        return unbanTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_function_auth.unban_time
     *
     * @param unbanTime the value for user_function_auth.unban_time
     *
     * @mbggenerated
     */
    public void setUnbanTime(Date unbanTime) {
        this.unbanTime = unbanTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_function_auth.reason
     *
     * @return the value of user_function_auth.reason
     *
     * @mbggenerated
     */
    public String getReason() {
        return reason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_function_auth.reason
     *
     * @param reason the value for user_function_auth.reason
     *
     * @mbggenerated
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_function_auth.created_time
     *
     * @return the value of user_function_auth.created_time
     *
     * @mbggenerated
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_function_auth.created_time
     *
     * @param createdTime the value for user_function_auth.created_time
     *
     * @mbggenerated
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_function_auth.modified_time
     *
     * @return the value of user_function_auth.modified_time
     *
     * @mbggenerated
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_function_auth.modified_time
     *
     * @param modifiedTime the value for user_function_auth.modified_time
     *
     * @mbggenerated
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}