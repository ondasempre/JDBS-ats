import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class psconn  implements DAOConstants {
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		Connection conn=null;
		
		PreparedStatement stmt1=null;
		try
		{
			
			System.out.println("inserisci il parametro di ricerca");
			String query=in.nextLine();
			Class.forName(JDBC_DRIVER); //carico il drivere della classe jdbc driver vi è il metoto getconnection perche ogni db ha un sua connessione differente e si deve ispezionare
			conn=DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			if(query!=null)
			{
				String searchVar=query.toLowerCase().trim();
				stmt1=conn.prepareStatement(SQL);
				stmt1.setString(1, "%"+searchVar+"%");
				stmt1.setString(2, "%"+searchVar+"%");
				
				ResultSet rs=stmt1.executeQuery();
				while(rs.next())
					System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
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
			finally
			{
				try
				{
					if(conn != null)
					{
						stmt1.close();
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