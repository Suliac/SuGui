package servlet.connection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Helper.DatabaseHelper;
import Managers.CategorieManager;
import Managers.UserManager;
import Model.Categorie;
import Model.User;

/**
 * Servlet implementation class AjoutCategorie
 */
@WebServlet("/ajouter-categorie")
public class AjoutCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutCategorie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<String> errorList = new ArrayList<String>();
		String nomCat = request.getParameter("nom");
		String desCat = request.getParameter("description");
		
		//On vérifie si tout les champs obligatoires sont remplis
		if ( nomCat.isEmpty() == true || desCat.isEmpty() == true ){
			errorList.add("Tout les champs ne sont pas remplis");
		} 

		//Si on a bien pas eu d'erreurs avant alors on peut continuer
		if(errorList.isEmpty() == true){
			
			//On prepare notre objet pour effectuer la requete sql
			DatabaseHelper dbHelper = new DatabaseHelper();
				
			//On prepare le manager de catégorie 
			CategorieManager cManager = new CategorieManager();
				
			//On crée notre catégorie a partir des infos récupérées
			Categorie c = new Categorie(nomCat, desCat);
				
			//On vérifie si la catégorie existe déjà ou non.
			if (cManager.IfCategorieExist(c)){
				errorList.add("L'utilisateur existe déjà");
				
			//Sinon on l'ajoute à la bdd
			}else{	
				cManager.AddCategorie(c);		
			}
				
			request.setAttribute("Errors", errorList);
			
			if(errorList.isEmpty() == false){		
				
				request.getRequestDispatcher("AjoutCategorie.jsp").forward(request, response);
				
			}else{
				request.getRequestDispatcher("accueil.jsp").forward(request, response);
			}
								
		}
			
			
	}
	
}
