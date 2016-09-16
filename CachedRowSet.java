

import com.sun.rowset.CachedRowSetImpl;//prop/libreres/doppio su jre secgli alternative
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

//stessa cosa del primo esercizio in maniera tutto interno :)
public class CachedRowSet implements DAOConstants{
	public static void main(String[] args) {
		new CachedRowSet();
	}
	public CachedRowSet() 
	{
		try {
			Class.forName(JDBC_DRIVER);
		CachedRowSetImpl cached= new CachedRowSetImpl();
		cached.setUrl(JDBC_URL);
		cached.setUsername(USERNAME);
		cached.setPassword(PASSWORD);
		cached.setCommand("create table esempio1(i int, nome varchar2(20))");//se select restituisce i dati associa il resultset a row tutto internamente
		cached.execute();
		cached.setCommand("select * from esempio1");
		cached.execute();
		cached.moveToInsertRow();
		cached.updateInt(1, 1);
		cached.updateString(2, "mario");
		cached.insertRow();
		cached.updateInt(1, 2);
		cached.updateString(2, "carlo");
		cached.insertRow();
		cached.moveToCurrentRow();//riallinamento del cursore per altrimenti faccio il commit di niente spostando il cursore alla fine per il commit perche se rimane all'inizion non fa il commit di niente
		cached.acceptChanges();
	}
	catch(ClassNotFoundException e)
	{
		System.out.println("driver non referenziato o stringa errata");
	}
	catch(SQLException e)
	{
		System.out.println(" motivo "+e.getMessage());
		System.out.println("codice errore "+e.getErrorCode());
	}
		
	}
}


