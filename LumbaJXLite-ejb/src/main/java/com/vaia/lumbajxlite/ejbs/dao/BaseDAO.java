package com.vaia.lumbajxlite.ejbs.dao;

import java.sql.Connection;

public abstract interface BaseDAO {

    public abstract void setConnection(Connection paramConnection);
}