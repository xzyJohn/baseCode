package com.xzy.basis.modules.system.service.impl;


import com.xzy.basis.modules.base.service.impl.BaseService;
import com.xzy.basis.modules.system.mapper.BasisUserMapper;
import com.xzy.basis.modules.system.po.BasisUser;
import com.xzy.basis.modules.system.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xzy
 * @date 2019/9/3 9:40
 */
@Service
public class TestServiceImpl extends BaseService<BasisUser> implements TestService {
    @Autowired
    private BasisUserMapper basisUserMapper;
}
