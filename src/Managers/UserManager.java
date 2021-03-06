package Managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.User;
import Helper.DatabaseHelper;

//Classe qui permettra de g�rer tous les utilisateurs dans une collection de 'User'
public class UserManager {

	/****************Attribut*****************/
	//Liste qui contient tous les utilisateurs
	private List<User> _usersList;

	/****************Constructeurs*****************/
		//Constructeur de base
	public UserManager(){
			_usersList = new ArrayList<User>();	
	}
	
	//Constructeur � partir d'une ancienne liste de personne
	public UserManager(List<User> usersList) {
		this._usersList = usersList;
	}

	/****************Accesseurs*****************/
	
	//Recup�re et met a jour la liste des utilisateurs
	public List<User> getUsersList() {
		return _usersList;
	}

	public void setUsersList(List<User> usersList) {
		this._usersList = usersList;
	}
	
	/****************M�thodes*****************/
	
	//R�cup�re les utilisateurs depuis la base de donn�e
		public User GetUserByIdPass(User u){
			//On cr�e notre helper
					
			
				DatabaseHelper dbHelper = new DatabaseHelper();
				ResultSet resultatRequete = null;
				String query = "SELECT * FROM USERS WHERE USE_ID = '"+ u.get_idUser() +"' AND USE_PAS = '"+ u.get_passwdUser()+"'";
				
				try {
					resultatRequete = dbHelper.ExecuteSQLQuerry(query);
					
					if(resultatRequete.next()){
							
						u.set_fnameUser(resultatRequete.getObject("USE_FIR").toString());
						u.set_nameUser(resultatRequete.getObject("USE_NAM").toString());
						u.set_nnameUser(resultatRequete.getObject("USE_NIC").toString());
											
					}
						
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.err.println("Erreur 1");
					e1.printStackTrace();
						
				}
					
					
		dbHelper.CloseDBH();
					
					
		return u;
	}	
		
	
	
	//Ajoute un utilisateur
	public void AddUser(User u){
		DatabaseHelper dbHelper = new DatabaseHelper();
		String query = "INSERT INTO USERS VALUES('" + u.get_idUser()+ "','" + u.get_nameUser() +"','" + u.get_fnameUser() +"','" +u.get_passwdUser() + "','" + u.get_imgUser() +"','"+ u.get_nnameUser() + "')";
		dbHelper.ExecuteSQLUpdate(query);
		dbHelper.CloseDBH();
	}
	
	//Supprime un utlisateur
	public void DelUser(){
		
	}
	
	//Met � jour un utilisateur
	public void UpdateUser(){
		
	}
	
	//Renvois faux si l'utilisateur n'existe pas et vrai si il existe
	public boolean IsUserExist(User u){
		
		boolean userExist = false;
		//On cr�e notre helper
		DatabaseHelper dbHelper = new DatabaseHelper();
		ResultSet resultatRequete = null;
		String query = "SELECT * FROM USERS WHERE USE_ID = '"+ u.get_idUser() +"' AND USE_PAS = '"+ u.get_passwdUser()+"'";
		String result = null;
		
		try {

			resultatRequete = dbHelper.ExecuteSQLQuerry(query);
			if(resultatRequete.next()){	
				userExist = true;				
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.err.println("Erreur 1");
			e1.printStackTrace();
			
		}
		
		dbHelper.CloseDBH();
		
		return userExist;
		}
	


public boolean IsUserIdExist(User u){
	
	boolean userExist = false;
	//On cr�e notre helper
	DatabaseHelper dbHelper = new DatabaseHelper();
	ResultSet resultatRequete = null;
	String query = "SELECT * FROM USERS WHERE USE_ID = '"+ u.get_idUser() +"'";
	String result = null;
	
	try {

		resultatRequete = dbHelper.ExecuteSQLQuerry(query);
		if(resultatRequete.next()){
			userExist = true;				
		}
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		System.err.println("Erreur 1");
		e1.printStackTrace();
		
	}
	
	
	dbHelper.CloseDBH();
	
	return userExist;
	}

	
}
