import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CallebleConnection  implements DAOConstants {
	public static void main(String[] args) {
		Connection conn=null;
		CallableStatement stmt=null;
		try
		{
			
			
			Class.forName(JDBC_DRIVER); //carico il drivere della classe jdbc driver vi è il metoto getconnection perche ogni db ha un sua connessione differente e si deve ispezionare
			conn=DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			stmt= conn.prepareCall(PLSQL);
			stmt.setInt(1, 3);
			stmt.setDouble(2, 200);
			stmt.execute();
				
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