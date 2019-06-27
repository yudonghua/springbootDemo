/**
 * @ProjectName: 智能建筑
 * @Copyright: 2017 HangZhou Hikvision System Technology Co., Ltd. All Right Reserved.
 * @address: http://www.hikvision.com
 * @date: 2018/8/27 15:18
 * @Description: 本内容仅限于杭州海康威视数字技术系统公司内部使用，禁止转发.
 */
package cn.yhd.dao;

import cn.yhd.bean.Friend;
import cn.yhd.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p></p>
 *
 * @author yuhuadong6 2018/8/27 15:18
 * @version V2.9
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人} 2018/8/27
 * @modify by reason:{方法名}:{原因}
 */
@Mapper
public interface FriendMapper {

    List<Friend> getFriendByUser(String username);
    List<Friend> getReqByUser(String username);
    void addFriend(Friend friend);
    void deleteFriend(Friend friend);
    void clearFriend(String name);
    void updateFriend(Friend friend);
}
