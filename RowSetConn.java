import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import com.sun.rowset.JdbcRowSetImpl;//prop/libreres/doppio su jre secgli alternative

//stessa cosa del primo esercizio in maniera tutto interno :)
public class RowSetConn implements DAOConstants{
	public static void main(String[] args) {
		new RowSetConn();
	}
	public RowSetConn() 
	{
		try {
			Class.forName(JDBC_DRIVER);
		
		JdbcRowSet row= new JdbcRowSetImpl();
		row.setUrl(JDBC_URL);
		row.setUsername(USERNAME);
		row.setPassword(PASSWORD);
		row.setCommand(SELECT_UTENTE);//se select restituisce i dati associa il resultset a row tutto internamente
		row.execute();
		ResultSetMetaData meta=row.getMetaData();// meta data da rs
		int colonne=meta.getColumnCount();
		for(int i=1; i<=colonne;i++)
			System.out.printf("%-10s\t\t", meta.getColumnName(i));
		System.out.println();
		while(row.next())
		{
			//scorro ora le colonne
			for(int i=1;i<=colonne;i++)
				System.out.printf("%-10s\t\t",row.getObject(i));
			System.out.println();
		}
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


