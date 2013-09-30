package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {

	private Connection _dbConnection;
	private String _dbUrl;
	private String _dbIdentifiant;
	private String _dbPassword;
	
	
	
		
	public DatabaseHelper(Connection _connection) {
		this._dbConnection = _connection;
		this._dbUrl = "jdbc:jtds:sqlserver://217.128.202.143:8080/SuGui";
		this._dbIdentifiant = "sa";
		this._dbPassword = "Mobile2013";
		
		
		
		
	}




	public void ExecuteSQLQuerry(){
			
		try{
				
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			
		}catch(ClassNotFoundException ex){
			
			System.err.println("Impossible de trouver le driver");
			System.exit(-1);
		}
		
		
		try{
			
			_dbConnection = DriverManager.getConnection(_dbUrl, _dbIdentifiant, _dbPassword);
			
			
			
		}catch(SQLException ex){
			ex.printStackTrace();
			System.err.println("Impossibe de se connecter a la bdd");
			System.exit(-1);
		} finally {
			
			if (_dbConnection != null)
			{
				try{
					_dbConnection.close();
				}catch(SQLException ex){
					ex.printStackTrace();
				}
			}
		}
			
	
	}
	
	
	
}