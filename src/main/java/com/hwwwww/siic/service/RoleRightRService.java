package com.hwwwww.siic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwwwww.siic.vo.Role;
import com.hwwwww.siic.vo.RoleRightR;

import java.util.List;

public interface RoleRightRService extends IService<RoleRightR> {

    public int del(int roleid, int rightid);

    public Role fenpei(int roleid, List<Integer> rightids);


}
