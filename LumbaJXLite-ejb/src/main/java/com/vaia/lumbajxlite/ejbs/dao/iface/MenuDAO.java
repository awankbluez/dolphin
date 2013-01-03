package com.vaia.lumbajxlite.ejbs.dao.iface;

import com.vaia.lumbajxlite.ejbs.dao.BaseDAO;
import com.vaia.lumbajxlite.ejbs.entity.Menu;
import com.vaia.lumbajxlite.ejbs.entity.Operatoruser;
import java.sql.SQLException;
import java.util.List;

public abstract interface MenuDAO extends BaseDAO {

    public abstract Menu findParentMenuBySubMenuId(Integer paramInteger)
            throws SQLException;

    public abstract List<Menu> findRootUserMenu(Operatoruser paramOperatoruser)
            throws SQLException;

    public abstract List<Menu> findRootUserReportMenu(Operatoruser paramOperatoruser)
            throws SQLException;

    public abstract List<Menu> retrieveUserSubMenuByParentMenuId(Operatoruser paramOperatoruser, Menu paramMenu)
            throws SQLException;

    public abstract List<Menu> retrieveUserReportSubMenuByParentMenuId(Operatoruser paramOperatoruser, Menu paramMenu)
            throws SQLException;
}