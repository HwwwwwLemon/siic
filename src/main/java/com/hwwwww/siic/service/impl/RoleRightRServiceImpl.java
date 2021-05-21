package com.hwwwww.siic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwwwww.siic.mapper.RoleMapper;
import com.hwwwww.siic.mapper.RoleRightRMapper;
import com.hwwwww.siic.service.RoleRightRService;
import com.hwwwww.siic.vo.Role;
import com.hwwwww.siic.vo.RoleRightR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleRightRServiceImpl extends ServiceImpl<RoleRightRMapper, RoleRightR> implements RoleRightRService {

    @Autowired
    RoleRightRMapper dao;
    @Autowired
    RoleMapper roledao;

    @Override
    public int del(int roleid, int rightid) {
        Map<String, Integer> map = new HashMap<>();
        map.put("roleid", roleid);
        map.put("rightid", rightid);

        return dao.del(map);
    }

    @Override
    public Role fenpei(int roleid, List<Integer> rightids) {

        if (rightids != null) {
            dao.delbyroleid(roleid);
            for (int i = 1; i < rightids.size(); i++) {
                RoleRightR r = new RoleRightR();
                r.setRoleid(roleid);
                r.setRightid(rightids.get(i));
                dao.insert(r);
            }
        }
        return roledao.getroles(roleid).get(0);
    }
}
