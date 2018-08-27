/**
 * @ProjectName: 智能建筑
 * @Copyright: 2017 HangZhou Hikvision System Technology Co., Ltd. All Right Reserved.
 * @address: http://www.hikvision.com
 * @date: 2018/8/27 15:16
 * @Description: 本内容仅限于杭州海康威视数字技术系统公司内部使用，禁止转发.
 */
package cn.yhd.bean;

/**
 * <p></p>
 *
 * @author yuhuadong6 2018/8/27 15:16
 * @version V2.9
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人} 2018/8/27
 * @modify by reason:{方法名}:{原因}
 */
public class Friend {
    private int status;
    private String username;
    private String friendname;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username= username;
    }

    public String getFriendname() {
        return friendname;
    }

    public void setFriendname(String friendname) {
        this.friendname = friendname;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
    public String toString(){
        return username + " " + friendname;
    }
}
