// Generated by BeanMaker V2, on September 19, 2022 at 1:17:22 PM COT
// Library Version #1.0-SNAPSHOT-build#20914

package org.beanmaker.labels;

import javax.annotation.processing.Generated;

import org.dbbeans.sql.DB;
import org.dbbeans.sql.DBAccess;
import org.dbbeans.sql.DBTransaction;

@Generated(value = "org.beanmaker.v2.codegen.DbBeanSourceFile", date = "2022-09-19T18:17:22.481587300Z", comments = "EDITABLE,1.0-SNAPSHOT-20914")
class DbBeans {

	static final DB db;
	static final DBAccess dbAccess;

	static {
		db = Configuration.getCurrentConfiguration().getDb();
		dbAccess = new DBAccess(db);
	}

	static DBTransaction createDBTransaction() {
		return new DBTransaction(db);
	}

}
