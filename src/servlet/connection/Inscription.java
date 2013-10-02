package servlet.connection;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Helper.DatabaseHelper;
import Managers.UserManager;
import Model.User;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//On récupère les informations du formulaire
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String passwordconf = request.getParameter("passwordconf");
		String nickname = request.getParameter("nickname");
		String picture = request.getParameter("picture");
			
		if( firstname.isEmpty() == false || lastname.isEmpty() == false || login.isEmpty() == false || password.isEmpty() == false || passwordconf.isEmpty() == false ){
			System.out.println("Tout les champs ne sont pas remplis");
		} else if ( password != passwordconf ){
			System.out.println("Les deux mots de passes ne sont pas les mêmes.");
		} else {
			
			//On prepare notre objet pour effectuer la requete sql
			DatabaseHelper dbHelper = new DatabaseHelper();
			
			//On prepare le manager d'utilisateur
			UserManager uManager = new UserManager();
			
			User u = new User(login,password,lastname,firstname,nickname,picture);
			
			//Si l'utilisateur existe on renvois vers la page index.html
			if (uManager.IsUserExist(u)){
				request.getRequestDispatcher("index.html");
			//Si non on l'ajoute à la bdd
			}else{
				uManager.AddUser(u);
			}
		}
		
		
		User u = new User();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
