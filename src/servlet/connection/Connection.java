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
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.print("Je suis ici");
		
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
					u = uManager.GetUserByIdPass(u);
					
					request.setAttribute("userLog", u);
					System.out.println("Je suis la");
					request.getRequestDispatcher("accueil.jsp").forward(request, response);
					
				}else{
					
					request.getRequestDispatcher("index.html").forward(request, response);
				}

			}
		
	

}
