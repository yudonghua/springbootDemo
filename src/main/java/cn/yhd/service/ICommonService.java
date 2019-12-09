package cn.yhd.service;

import cn.yhd.base.IBaseService;
import cn.yhd.entity.TbUser;
import cn.yhd.entity.TbUserExample;

public interface ICommonService {
    <T> void saveXxx(IBaseService baseService,T a);
}
