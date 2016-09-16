import java.sql.*;

public class Secondaconne  implements DAOConstants {
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		try
		{
			Class.forName(JDBC_DRIVER); //carico il drivere della classe jdbc driver vi è il metoto getconnection perche ogni db ha un sua connessione differente e si deve ispezionare
			conn=DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);//tutti i tipo di stmt sono creati sulla connessione
			stmt.executeUpdate("insert into utente values('Anna','verdi','anna')");
			System.out.println("inserita nuova riga");
			ResultSet rs=stmt.executeQuery("select username from utente where username='anna'");
			rs.first();//sensibile ai cambiamenti
			rs.updateString("username", "PAOLa");
			System.out.println("aggiornata riga");
			rs.updateRow();
			
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
		finally
		{
			try
			{
				if(conn != null)
				{
					stmt.close();
					conn.close();
				}
			}
			catch(SQLException e)
			{
				System.out.println(" motivo "+e.getMessage());
				System.out.println("codice errore "+e.getErrorCode());
			}
		}
	}

}



