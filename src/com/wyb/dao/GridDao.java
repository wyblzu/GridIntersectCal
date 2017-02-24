package com.wyb.dao;

import org.hibernate.*;
import com.wyb.util.*;
import com.wyb.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyb on 2017/2/23.
 */
public class GridDao {

    public List<Grid> listGirds(){
        SessionFactory sessionFactory = HibernateUtil.sessionFactory(Grid.class);
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Grid> grids = new ArrayList<>();
        String sql = "select gid as id, gridkey as gridkey,ST_AsText(geom) as wktString from quadgrid_18";
        try{
            transaction = session.beginTransaction();
            SQLQuery sqlQuery = session.createSQLQuery(sql);
            sqlQuery.addEntity(Grid.class);
            grids = sqlQuery.list();
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return grids;
    }
}
