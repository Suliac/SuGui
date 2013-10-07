package Managers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Helper.DatabaseHelper;
import Model.Film;

public class FilmManager {
	
	/****************Attribut*****************/
	//Liste qui contient toutes les catégories
	private List<Film> _filmsList;

	/****************Constructeurs*****************/
		//Constructeur de base
	public FilmManager(){
		_filmsList = new ArrayList<Film>();	
	}
	
	//Constructeur à partir d'une ancienne liste de catégorie
	public FilmManager(List<Film> filmsList) {
		this._filmsList = _filmsList;
	}

	/****************Accesseurs*****************/
	
	//On récupère et met a jour la liste des catégories
	public List<Film> getFilmsList() {
		return _filmsList;
	}

	public void setFilmsList(List<Film> filmsList) {
		this._filmsList = filmsList;
	}
	
	/****************Méthodes*****************/
	
	//On récupère les catégories depuis la base de donnée
	public void GetFilms(){
		
		
	}
	
	//Ajoute un Film
	public void AddFilm(Film f){
		DatabaseHelper dbHelper = new DatabaseHelper();
		String query = "INSERT INTO FILM VALUES('" + f.get_filmName() + "','" + f.get_filmDesc() +"','" + f.get_filmReal() +"','" + f.get_filmDateSortie() +"')";
		dbHelper.ExecuteSQLQuerry(query);
		dbHelper.CloseDBH();
	}
	
	//Supprime un film
	public void DelFilm(){
		
	}
	
	//Met à jour un film
	public void UpdateFilm(){
		
	}
	
	//Renvois faux si le film n'existe pas et vrai si il existe
	public boolean IfFilmExist(Film f){
		
		boolean filmExist = false;
		//On crée notre helper
		DatabaseHelper dbHelper = new DatabaseHelper();
		ResultSet resultatRequete = null;
		String query = "SELECT * FROM FILM WHERE FIL_NOM = '"+ f.get_filmName() +"'";
		String result = null;
		
		try {

			resultatRequete = dbHelper.ExecuteSQLQuerry(query);
			if(resultatRequete.next()){
				filmExist = true;				
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.err.println("Erreur 1");
			e1.printStackTrace();
			
		}
		
		
		dbHelper.CloseDBH();
		
		return filmExist;
		}

}
