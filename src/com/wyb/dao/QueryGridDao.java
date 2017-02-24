package com.wyb.dao;

import com.wyb.model.Polygon;
import com.wyb.model.QueryGrid;
import com.wyb.util.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyb on 2017/2/24.
 */
public class QueryGridDao {

    public List<QueryGrid> queryGridList(){
        SessionFactory sessionFactory = HibernateUtil.sessionFactory(QueryGrid.class);
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<QueryGrid> queryGrids = new ArrayList<>();
        String sql = "select a.gid as id, a.gridkey as geokey,b.name from quadgrid_18 a join zd_ring b on " +
                "ST_Contains" +
                "(b" +
                ".geom, " +
                "ST_Centroid(a.geom))";
        try{
            transaction = session.beginTransaction();
            SQLQuery sqlQuery = session.createSQLQuery(sql);
            sqlQuery.addEntity(QueryGrid.class);
            queryGrids = sqlQuery.list();
        }catch (HeadlessException e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return queryGrids;
    }
}
