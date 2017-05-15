/**
 * Copyright 2015-2017 Sree Vaddi.
 */
package org.sreev.db.mysql;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.cj.api.xdevapi.Collection;
import com.mysql.cj.api.xdevapi.RowResult;
import com.mysql.cj.api.xdevapi.Schema;
import com.mysql.cj.api.xdevapi.Table;
import com.mysql.cj.api.xdevapi.XSession;
import com.mysql.cj.xdevapi.XSessionFactory;

/**
 * Main Class
 * 
 * @author svaddi
 */
public class Main {
	private static final Logger LOG = LoggerFactory.getLogger(Main.class);
	
	// db user name is 'root' ;-)
	private static final String X_URL = "mysqlx://localhost:33060/world_x?useSSL=false&user=root&password=";
	
	/**
	 * 
	 */
	public Main() {
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.debug("main(String[])");
		
		XSession xSession = new XSessionFactory().getSession(X_URL+args[0]);
		Schema world = xSession.getSchema("world_x");
		
		Collection cityCollection = world.getCollection("city");
		LOG.debug("city.size {}", cityCollection.count());
		
		//world_x is not setup to be a doc store. so the following doesn't work.
//		DocResult docResult = cityCollection.find("name like 'K%'").execute();
//		DocResult docResult = cityCollection.find().execute();
//		LOG.debug("count {}", docResult.count());
//		LOG.debug("one {}", docResult.fetchOne());
		
		Table table = world.getTable("city");
		LOG.debug("city.count {}", table.count());
		RowResult rowResult = table.select("*").where("name like 'A%'").execute();
//		RowResult rowResult = table.select("name like :param").limit(1).bind("param", "K%").execute();
		LOG.debug("rowResult.count {}", rowResult.count());
//		Row row = rowResult.fetchOne();
//		LOG.debug("row {} {}", row.getString(1), row.getString(2));
		
		List<String> columnNames = rowResult.getColumnNames();
		
		rowResult.fetchAll().forEach(row -> {
			columnNames.forEach(name -> {
				LOG.debug("{} = {}", name, row.getString(name));
			});
		});
		
		xSession.close();
		LOG.debug("done!");
	}
}
