package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Permet d'executer plus facilement les requetes SQL
public class DatabaseHelper {

	private Connection _dbConnection;
	private String _dbUrl;
	private String _dbIdentifiant;
	private String _dbPassword;
	
	
	
	//Initialisation et test de connection à la base de donnée
	public DatabaseHelper(Connection _connection) {
		this._dbConnection = _connection;
		this._dbUrl = "jdbc:jtds:sqlserver://217.128.202.143:8080/SuGui";
		this._dbIdentifiant = "sa";
		this._dbPassword = "Mobile2013";
		
		try{
			_dbConnection = DriverManager.getConnection(_dbUrl, _dbIdentifiant, _dbPassword);	
			
			_dbConnection.close();
			
		}catch(SQLException ex){
			ex.printStackTrace();
			System.err.println("Impossibe de se connecter a la bdd (From DatabaseHelper.java)");
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



	//Méthode d'execution des requêtes SQL
	public ResultSet ExecuteSQLQuerry(String request){
		
		//On initialise le driver
		try{
				
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			
		}catch(ClassNotFoundException ex){
			
			System.err.println("Impossible de trouver le driver");
			System.exit(-1);
		}
		
		Statement state;
		ResultSet resultatStatement =null;
		
		try{
			//On crée la connection
			_dbConnection = DriverManager.getConnection(_dbUrl, _dbIdentifiant, _dbPassword);
			
			state = this._dbConnection.createStatement();
			
			//On récupère les valeurs renvoyés (si il y en a) par la requete SQL
			resultatStatement = state.executeQuery(request);
			
			//On ferme la connection
			_dbConnection.close();
			
			
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
		return resultatStatement;
			
		
		
	}
	
	
	
}