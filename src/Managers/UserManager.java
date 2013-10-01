package Managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.User;
import Helper.DatabaseHelper;

//Classe qui permettra de gérer tous les utilisateurs dans une collection de 'User'
public class UserManager {

	/****************Attribut*****************/
	//Liste qui contient tous les utilisateurs
	private List<User> _usersList;

	/****************Constructeurs*****************/
		//Constructeur de base
	public UserManager(){
			_usersList = new ArrayList<User>();	
	}
	
	//Constructeur à partir d'une ancienne liste de personne
	public UserManager(List<User> usersList) {
		this._usersList = usersList;
	}

	/****************Accesseurs*****************/
	
	//Recupère et met a jour la liste des utilisateurs
	public List<User> getUsersList() {
		return _usersList;
	}

	public void setUsersList(List<User> usersList) {
		this._usersList = usersList;
	}
	
	/****************Méthodes*****************/
	
	//Récupère les utilisateurs depuis la base de donnée
	public void GetUsers(){
		
		
	}
	
	//Ajoute un utilisateur
	public void AddUser(){
		
	}
	
	//Supprime un utlisateur
	public void DelUser(){
		
	}
	
	//Met à jour un utilisateur
	public void UpdateUser(){
		
	}
	
	//Renvois faux si l'utilisateur n'existe pas et vrai si il existe
	public boolean IsUserExist(User u){
		
		boolean userExist = false;
		//On crée notre helper
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
	}

