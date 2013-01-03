package com.vaia.lumbajxlite.ejbs.dao.iface;

import com.vaia.lumbajxlite.ejbs.dao.BaseDAO;
import com.vaia.lumbajxlite.ejbs.entity.Operatoruser;
import java.util.List;

public abstract interface OperatorUserDAO extends BaseDAO {

    public abstract Operatoruser checkLogin(Operatoruser paramOperatoruser);

    public abstract List<Operatoruser> retrieveAllUser();
}