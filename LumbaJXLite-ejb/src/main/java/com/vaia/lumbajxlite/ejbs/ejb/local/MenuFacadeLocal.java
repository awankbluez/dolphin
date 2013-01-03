package com.vaia.lumbajxlite.ejbs.ejb.local;

import com.vaia.lumbajxlite.ejbs.entity.Menu;
import com.vaia.lumbajxlite.ejbs.entity.Operatoruser;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Local;

@Local
public abstract interface MenuFacadeLocal {

    public abstract void create(Menu paramMenu);

    public abstract void edit(Menu paramMenu);

    public abstract void remove(Menu paramMenu);

    public abstract Menu find(Object paramObject);

    public abstract List<Menu> findAll();

    public abstract List<Menu> findRange(int[] paramArrayOfInt);

    public abstract int count();

    public abstract List<Menu> findRootUserMenu(Operatoruser paramOperatoruser)
            throws SQLException;

    public abstract List<Menu> findRootUserReportMenu(Operatoruser paramOperatoruser)
            throws SQLException;

    public abstract List<Menu> retrieveUserSubMenuByParentMenuId(Operatoruser paramOperatoruser, Menu paramMenu)
            throws SQLException;

    public abstract List<Menu> retrieveUserReportSubMenuByParentMenuId(Operatoruser paramOperatoruser, Menu paramMenu)
            throws SQLException;

    public abstract String retrieveString();
}