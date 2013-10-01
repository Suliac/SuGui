package servlet.connection;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.User;
import Helper.DatabaseHelper;
import Managers.UserManager;

/**
 * Servlet implementation class Connection
 */
@WebServlet("/connection")
public class Connection extends HttpServlet {
	
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Requete SQL
		String querry = null;
		
		//On prepare notre objet pour effectuer une requete sql
		DatabaseHelper dbHelper = new DatabaseHelper();
		
		//On rpepare notre manager d'utilisateurs
		UserManager uManager = new UserManager();
		
		//On récupère le login et le mot de passe entrés par l'utilisateur
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		User u = new User(login, password);
		
		//Si le compte est bien existant, alors :
		if (uManager.IsUserExist(u))
		{
			//On passe a la page d'acceuil en envoyant les infos voulues
			
			request.setAttribute("userLog", u);
			request.getRequestDispatcher("accueil.jsp").forward(request, response);
			
		}else{
			//Si le compte n'est pas existant on envois les erreurs
			String error = null;
			
			//Si le Login n'a pas été renseigné
			if(login.isEmpty() == false ){
			//Sinon on envois le probleme
				error = "L";
				if(password.isEmpty() == false){
					//et si le mdp n'est pas rensigné aussi on met a jour notre infos qui sera envoyée
					error = "LP";
				
				}
			}else if(password.isEmpty() == false){
				//
				error = "P";
			
			}
			request.setAttribute("error", error);
			request.getRequestDispatcher("index.html").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
