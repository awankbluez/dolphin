package com.vaia.lumbajxlite.ejbs.dao;

import com.vaia.lumbajxlite.ejbs.dao.iface.OperatorUserDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FactoryDAO {

    static Logger logger = LoggerFactory.getLogger(FactoryDAO.class);
    public static DataSource ds;
    public static Connection conn;
    public static OperatorUserDAO operatorUserDAO;

    private static Connection getConnection()
            throws SQLException {
        Connection connection = null;
        if (conn != null) {
            connection = conn;
        } else if (conn == null) {
            try {
                Context ctx = new InitialContext();
                ds = (DataSource) ctx.lookup("jdbc/Lumba");
                conn = ds.getConnection();
            } catch (NamingException ex) {
                logger.error(ex.toString());
            } catch (SQLException sQLException) {
                logger.error("Error getting connection : {}", sQLException.toString());
            }
            connection = conn;
        }
        return connection;
    }

    public static Connection getConn() throws SQLException {
        Connection connection = null;
        if (conn != null) {
            connection = conn;
        } else {
            connection = getConnection();
        }

        return connection;
    }

    public static <DAO extends BaseDAO> DAO getDAOImpl(Class<DAO> daoInterface) {
        DAO daoImplementation = null;
        String daoInterfaceName = daoInterface.getName();

        if (!daoInterface.isInterface()) {
            logger.error("Class '{}' is actually not an Interface.", daoInterfaceName);
        }

        String daoImplClassName = getDAOImplClassName(daoInterfaceName);
        try {
            daoImplementation = daoInterface.cast(Class.forName(daoImplClassName).newInstance());
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            logger.error(e.toString());
        }
        try {
            daoImplementation.setConnection(getConnection());
        } catch (SQLException ex) {
            logger.error(ex.toString());
        }

        return daoImplementation;
    }

    private static String getDAOImplClassName(String dAOInterfaceClassName) {
        String[] daoImplClassNameArrays = new String[0];
        daoImplClassNameArrays = dAOInterfaceClassName.split("\\.");

        StringBuilder sb = new StringBuilder();
        for (String packageName : daoImplClassNameArrays) {
            if (packageName.contains("iface")) {
                packageName = "impl";
            }

            sb.append(packageName);
            sb.append(".");
        }

        String daoImplClassName = sb.toString();
        daoImplClassName = daoImplClassName.substring(0, daoImplClassName.length() - 1).concat("Impl");

        return daoImplClassName;
    }
}