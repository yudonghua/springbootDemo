package cn.yhd.service.impl;

import cn.yhd.base.BaseServiceImpl;
import cn.yhd.base.IBaseMapper;
import cn.yhd.base.IBaseService;
import cn.yhd.dao.ITbUserMapper;
import cn.yhd.entity.TbUser;
import cn.yhd.entity.TbUserExample;
import cn.yhd.service.ICommonService;
import cn.yhd.service.ITbUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommonServiceImpl implements ICommonService {

    @Override
    public <T> void saveXxx(IBaseService baseService,T a) {
        funA();
        baseService.insert(a);
        funB();
    }
    private void funA(){

    }
    private void funB(){

    }


}
