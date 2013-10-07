package servlet.connection;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Helper.DatabaseHelper;
import Managers.CategorieManager;
import Managers.FilmManager;
import Model.Categorie;
import Model.Film;

/**
 * Servlet implementation class AjoutFilm
 */
@WebServlet("/ajouter-film")
public class AjoutFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutFilm() {
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
		
		String nom = request.getParameter("nom");		
		String description = request.getParameter("description");		
		String realisateur = request.getParameter("realisateur");		
		String datedesortie = request.getParameter("datedesortie");
		//Conversion de la datedesortie en String en Date.
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		if ( nom.isEmpty() == true || description.isEmpty() == true || realisateur.isEmpty() == true || datedesortie.isEmpty() == true ){
			errorList.add("Tout les champs ne sont pas remplis");
		} else {
			
			//On prepare notre objet pour effectuer la requete sql
			DatabaseHelper dbHelper = new DatabaseHelper();
			
			//On prepare le manager de film 
			FilmManager fManager = new FilmManager();
				
			Film f = null;
			try {
				f = new Film(nom, description, realisateur, sdf.parse(datedesortie));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			//On vérifie si le film existe déjà ou non.
			if (fManager.IfFilmExist(f)){
				errorList.add("Le film existe déjà");					
			//Sinon on l'ajoute à la bdd
			}else{		
				fManager.AddFilm(f);
			}
				
		}
		
		request.setAttribute("Errors", errorList);
		
		if(errorList.isEmpty() == false){
			request.getRequestDispatcher("AjoutFilm.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("accueil.jsp").forward(request, response);
		}
		
		
	}

}
