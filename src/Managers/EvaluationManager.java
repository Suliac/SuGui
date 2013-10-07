package Managers;

//Permet de gérer toutes les évaluations dans une liste.
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Helper.DatabaseHelper;
import Model.Evaluation;

public class EvaluationManager {


		/****************Attribut*****************/
		//Liste qui contient tous les evaluations
		private List<Evaluation> _evaluationsList;

		/****************Constructeurs*****************/
			//Constructeur de base
		public EvaluationManager(){
				_evaluationsList = new ArrayList<Evaluation>();	
		}
		
		//Constructeur à partir d'une ancienne liste d'evaluation
		public EvaluationManager(List<Evaluation> evaluationsList) {
			this._evaluationsList = evaluationsList;
		}

		/****************Accesseurs*****************/
		
		//Recupère et met a jour la liste des evaluations
		public List<Evaluation> getEvaluationsList() {
			return _evaluationsList;
		}

		public void setUsersList(List<Evaluation> evaluationsList) {
			this._evaluationsList = evaluationsList;
		}
		
		/****************Méthodes*****************/
		
		//Récupère les evaluations depuis la base de donnée
		public void GetEvaluations(){
			
			
		}
		
		//Ajoute une evaluation
		public void AddUser(Evaluation e){
			DatabaseHelper dbHelper = new DatabaseHelper();
			String query = "INSERT INTO EVALUE VALUES('" + e.get_evaUtilisateur()+ "','" + e.get_evaFilm() +"','" + e.get_evaNote() +"','" + e.get_evaTit()+ "','" + e.get_evaDes() +"')";
			dbHelper.ExecuteSQLUpdate(query);
			dbHelper.CloseDBH();
		}
		
		//Supprime une evaluation
		public void DelUser(){
			
		}
		
		
		
		//Met à jour une evaluation
		public void UpdateUser(){
			
		}
		
		//Renvois faux si l'evaluation n'existe pas et vrai si il existe
		public boolean IsEvaluationExist(Evaluation e){
			
			boolean evaluationExist = false;
			//On crée notre helper
			DatabaseHelper dbHelper = new DatabaseHelper();
			ResultSet resultatRequete = null;
			String query = "SELECT * FROM EVALUE WHERE EVA_ID_USER = '"+ e.get_evaUtilisateur() +"' AND EVA_NOM_FILM = '"+ e.get_evaFilm() +"'";
			String result = null;
			
			try {

				resultatRequete = dbHelper.ExecuteSQLQuerry(query);
				if(resultatRequete.next()){
					evaluationExist = true;				
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.err.println("Erreur 1");
				e1.printStackTrace();
				
			}
			
			
			dbHelper.CloseDBH();
			
			return evaluationExist;
		}
		
			
	



}
