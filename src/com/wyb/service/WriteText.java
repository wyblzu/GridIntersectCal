package com.wyb.service;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import com.wyb.dao.GridDao;
import com.wyb.dao.PolygonDao;
import com.wyb.dao.QueryGridDao;
import com.wyb.model.Grid;
import com.wyb.model.Polygon;
import com.wyb.model.QueryGrid;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by wyb on 2017/2/23.
 */
public class WriteText {


    public void gridToText(){
        PolygonDao polygonDao = new PolygonDao();
        GridDao gridDao = new GridDao();
        List<Polygon> polygons = polygonDao.listPolygon();
        List<Grid> grids = gridDao.listGirds();
        File file = new File("e:\\zd_ring_18.csv");
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fileWriter = null;
            fileWriter = new FileWriter(file,true);
            PrintWriter pw = new PrintWriter(file);
            String headString = "geokey,name";
            pw.println(headString);
            pw.flush();
            for(Polygon polygon:polygons){
                Geometry gPolygon = new WKTReader().read(polygon.getWktString());
                for(Grid grid:grids){
                    Geometry gGrid = new WKTReader().read(grid.getWktString());
                    Point centerPoint = gGrid.getCentroid();
                    if(gPolygon.contains(centerPoint)){
                        String resultString = grid.getGridKey() + "," + polygon.getName();
                        pw.println(resultString);
                        pw.flush();
                    }
                }
            }
            fileWriter.flush();
            pw.close();
            fileWriter.close();
            System.out.print("写入完成！");

        }catch (ParseException | IOException e){
            e.printStackTrace();
            if(e instanceof IOException ){
                System.out.println("创建文件夹失败！");
            }
        }

    }
    public void gridToText1(){
        QueryGridDao queryGridDao = new QueryGridDao();
        List<QueryGrid> queryGrids = queryGridDao.queryGridList();
        File file = new File("e:\\zd_ring_18.csv");
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file,true);
            PrintWriter pw = new PrintWriter(file);
            String headString = "geokey,name";
            pw.println(headString);
            pw.flush();
            for(QueryGrid queryGrid:queryGrids){
                String geokey = queryGrid.getGeokey();
                String name = queryGrid.getName();
                pw.println(geokey + "," + name);
                pw.flush();
            }
            fileWriter.flush();
            pw.close();
            fileWriter.close();
            System.out.print("写入完成！");
        }catch ( IOException e){
            e.printStackTrace();
        }
    }

}
