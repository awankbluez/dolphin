package com.vaia.lumbajxlite.ejbs.ejb.local;

import com.vaia.lumbajxlite.ejbs.entity.Operatoruser;
import java.util.List;
import javax.ejb.Local;

@Local
public abstract interface OperatorUserFacadeLocal {

    public abstract void create(Operatoruser paramOperatoruser);

    public abstract void edit(Operatoruser paramOperatoruser);

    public abstract void remove(Operatoruser paramOperatoruser);

    public abstract Operatoruser find(Object paramObject);

    public abstract List<Operatoruser> findAll();

    public abstract List<Operatoruser> findRange(int[] paramArrayOfInt);

    public abstract int count();

    public abstract Operatoruser checkUser(Operatoruser paramOperatoruser);
}