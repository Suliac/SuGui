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
import Managers.EvaluationManager;
import Managers.UserManager;
import Model.Evaluation;
import Model.User;

/**
 * Servlet implementation class AjoutEvaluation
 */
@WebServlet("/ajouter-evaluation")
public class AjoutEvaluation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutEvaluation() {
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
		//On créer une liste de String dans laquel on ajoutera les erreurs si il y en a
		List<String> errorList = new ArrayList<String>();
		
		String utilisateur = request.getParameter("utilisateur");
		String film = request.getParameter("film");
		String note = request.getParameter("note");
		String titre = request.getParameter("titre");
		String description = request.getParameter("description");
		
		if ( utilisateur.isEmpty() == true || film.isEmpty() == true || note.isEmpty() == true || titre.isEmpty() == true || description.isEmpty() == true ){
			errorList.add("Tout les champs ne sont pas remplis");
		} else {
			
			//On prepare notre objet pour effectuer la requete sql
			DatabaseHelper dbHelper = new DatabaseHelper();
			
			//On prepare le manager d'utilisateur
			EvaluationManager eManager = new EvaluationManager();
			
			//Integer.parseInt > Transfert d'un string en int.
			Evaluation e = new Evaluation(utilisateur, film, Integer.parseInt(note), titre, description);
			
			//Si l'utilisateur existe on renvois vers la page index.html
			if (eManager.IsEvaluationExist(e)){
				errorList.add("Vous avez déjà évaluer ce film.");
			//Si non on l'ajoute à la bdd
			}else{
				eManager.AddUser(e);
			}
		
			request.setAttribute("Errors", errorList);
			
			if (errorList.isEmpty() == false){
				request.getRequestDispatcher("AjouterEvaluation.jsp").forward(request, response);
			} else
			{
				request.getRequestDispatcher("accueil.jsp").forward(request, response);
			}
		
		
			
		}
		
	}
	
	
	
}


