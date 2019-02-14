package com.voltdb.example;

import org.json.simple.JSONObject;
import org.voltdb.SQLStmt;
import org.voltdb.VoltProcedure;
import org.voltdb.VoltTable;
import org.voltdb.VoltType;

public class SayHello extends VoltProcedure {
    
	public static final SQLStmt SELECT = new SQLStmt("SELECT text FROM hello WHERE language=? order by language, text"); 
	
	public VoltTable[] run(String language) {
		voltQueueSQL(SELECT, language);
		VoltTable result = voltExecuteSQL()[0];
		VoltTable[] voltTable = {new VoltTable(new VoltTable.ColumnInfo("text", VoltType.STRING))};
		if(result.advanceRow()) {
			String text = result.getString(0);
			JSONObject obj = new JSONObject();
			obj.put(language, text);
			voltTable[0].addRow(obj.toString());
		}
		return voltTable;
	}
}
