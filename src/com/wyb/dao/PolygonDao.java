package com.wyb.dao;

import com.wyb.model.Grid;
import com.wyb.model.Polygon;
import com.wyb.util.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by wyb on 2017/2/23.
 */
public class PolygonDao {

    public List<Polygon> listPolygon(){
        SessionFactory sessionFactory = HibernateUtil.sessionFactory(Polygon.class);
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Polygon> polygons = new ArrayList<>();
        String sql = "select gid as id, ST_AsText(geom) as wktString,name from zd_ring";
        try{
            transaction = session.beginTransaction();
            SQLQuery sqlQuery = session.createSQLQuery(sql);
            sqlQuery.addEntity(Polygon.class);
            polygons = sqlQuery.list();
        }catch (HeadlessException e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return polygons;
    }




}
