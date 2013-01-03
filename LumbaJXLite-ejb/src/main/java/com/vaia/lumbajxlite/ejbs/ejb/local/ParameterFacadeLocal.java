package com.vaia.lumbajxlite.ejbs.ejb.local;

import com.vaia.lumbajxlite.ejbs.entity.Parameter;
import java.util.List;
import javax.ejb.Local;

@Local
public abstract interface ParameterFacadeLocal {

    public abstract void create(Parameter paramParameter);

    public abstract void edit(Parameter paramParameter);

    public abstract void remove(Parameter paramParameter);

    public abstract Parameter find(Object paramObject);

    public abstract List<Parameter> findAll();

    public abstract List<Parameter> findRange(int[] paramArrayOfInt);

    public abstract int count();

    public abstract List<Parameter> findByCode(String paramString);
}