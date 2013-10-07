package Managers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Helper.DatabaseHelper;
import Model.Categorie;


	//Classe qui permettra de g�rer toutes les cat�gories dans une collection de 'Categorie'
	public class CategorieManager {

		/****************Attribut*****************/
		//Liste qui contient toutes les cat�gories
		private List<Categorie> _categoriesList;

		/****************Constructeurs*****************/
			//Constructeur de base
		public CategorieManager(){
			_categoriesList = new ArrayList<Categorie>();	
		}
		
		//Constructeur � partir d'une ancienne liste de cat�gorie
		public CategorieManager(List<Categorie> categoriesList) {
			this._categoriesList = _categoriesList;
		}

		/****************Accesseurs*****************/
		
		//On r�cup�re et met a jour la liste des cat�gories
		public List<Categorie> getCategoriesList() {
			return _categoriesList;
		}

		public void setCategoriesList(List<Categorie> categoriesList) {
			this._categoriesList = categoriesList;
		}
		
		/****************M�thodes*****************/
		
		//On r�cup�re les cat�gories depuis la base de donn�e
		public void GetCategories(){
			
			
		}
		
		//Ajoute une cat�gorie
		public void AddCategorie(Categorie c){
			DatabaseHelper dbHelper = new DatabaseHelper();
			String query = "INSERT INTO CATEGORIE VALUES('" + c.get_catName() + "','" +c.get_catDesc() +"')";
			dbHelper.ExecuteSQLUpdate(query);
			dbHelper.CloseDBH();
		}
		
		//Supprime une cat�gorie
		public void DelCategorie(){
			
		}
		
		//Met � jour une cat�gorie
		public void UpdateCategorie(){
			
		}
		
		//Renvois faux si la cat�gorie n'existe pas et vrai si elle existe
		public boolean IfCategorieExist(Categorie c){
			
			boolean categorieExist = false;
			//On cr�e notre helper
			DatabaseHelper dbHelper = new DatabaseHelper();
			ResultSet resultatRequete = null;
			String query = "SELECT * FROM CATEGORIE WHERE CAT_NOM = '"+ c.get_catName() +"'";
			String result = null;
			
			try {

				resultatRequete = dbHelper.ExecuteSQLQuerry(query);
				if(resultatRequete.next()){
					categorieExist = true;				
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.err.println("Erreur 1");
				e1.printStackTrace();
				
			}
			
			
			dbHelper.CloseDBH();
			
			return categorieExist;
			}
	
}
