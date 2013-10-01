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
	
	
	/*******************Accesseurs*******************/
	
	public Connection get_dbConnection() {
		return _dbConnection;
	}



	public void set_dbConnection(Connection _dbConnection) {
		this._dbConnection = _dbConnection;
	}



	public String get_dbUrl() {
		return _dbUrl;
	}



	public void set_dbUrl(String _dbUrl) {
		this._dbUrl = _dbUrl;
	}



	public String get_dbIdentifiant() {
		return _dbIdentifiant;
	}



	public void set_dbIdentifiant(String _dbIdentifiant) {
		this._dbIdentifiant = _dbIdentifiant;
	}



	public String get_dbPassword() {
		return _dbPassword;
	}



	public void set_dbPassword(String _dbPassword) {
		this._dbPassword = _dbPassword;
	}



	//Initialisation et test de connection à la base de donnée
	public DatabaseHelper() {
		this._dbConnection = null;
		this._dbUrl = "jdbc:jtds:sqlserver://217.128.202.143:1433/SuGui";
		this._dbIdentifiant = "sa";
		this._dbPassword = "Mobile2013";

		
	}



	//Méthode d'execution des requêtes SQL
	public ResultSet ExecuteSQLQuerry(String request){
				
		
		try{
			try {
				Class.forName("net.sourceforge.jtds.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Problème avec la plugin (dans DatabaseHeper.java)");
			}
			
			_dbConnection = DriverManager.getConnection(_dbUrl, _dbIdentifiant, _dbPassword);	
			
			
		}catch(SQLException ex){
			ex.printStackTrace();
			System.err.println("Impossibe de se connecter a la bdd (From DatabaseHelper.java)");
		} 
		
		
		Statement state;
		ResultSet resultatStatement =null;
		
		try{
			
			state = this._dbConnection.createStatement();
			
			System.out.println(request);
			
			resultatStatement = state.executeQuery(request);
			

		}catch(SQLException ex){
			ex.printStackTrace();
		} 
		
		//On récupère les valeurs renvoyés (si il y en a) par la requete SQL
		/*try {
			System.out.println(resultatStatement.getObject(1).toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		return resultatStatement;
				
		
	}
	
	
	public void CloseDBH(){
		
		try {
			this._dbConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}