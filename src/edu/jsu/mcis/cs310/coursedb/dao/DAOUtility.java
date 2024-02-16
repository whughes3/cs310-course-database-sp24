package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;
import java.util.ArrayList;

public class DAOUtility {
    
    public static final int TERMID_FA24 = 1;
    
    public static String getResultSetAsJson(ResultSet rs) {
        
        JsonArray records = new JsonArray();
        
        try {
        
            if (rs != null) {

                // INSERT YOUR CODE HERE 
                ResultSetMetaData metaD = rs.getMetaData();
                int cCount = metaD.getColumnCount();
                
                while (rs.next()) {
                    JsonObject obj = new JsonObject();
                    for (int i = 1; i <= cCount; i++){
                        String cName = metaD.getColumnName(i);
                        Object val = rs.getObject(i);
                        
                        obj.put(cName, val.toString());
                    }
                    records.add(obj);
                }

            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return Jsoner.serialize(records);
        
    }
    
}
