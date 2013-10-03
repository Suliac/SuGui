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
import Managers.UserManager;
import Model.User;

/**
 * Servlet implementation class ServletInscription
 */
@WebServlet("/servletinscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
				List<String> errorList = new ArrayList<String>();
		
		//On récupère les informations du formulaire
				String firstname = request.getParameter("firstname");
				String lastname = request.getParameter("lastname");
				String login = request.getParameter("login");
				String password = request.getParameter("password");
				String passwordconf = request.getParameter("passwordconf");
				String nickname = request.getParameter("nickname");
				String picture = request.getParameter("picture");
				
				//Si tout les champs necessaires ne sont pas bien remplis on charge une erreur
				if( firstname.isEmpty() == true || lastname.isEmpty() == true || login.isEmpty() == true || password.isEmpty() == true || passwordconf.isEmpty() == true ){
					//System.out.println("Tout les champs ne sont pas remplis.");
					errorList.add("Tout les champs ne sont pas remplis.");
					
				//Si les mots de passes diffèrent alors on charge une erreur
				} else if (!password.equals(passwordconf)){
					//System.out.println("Les deux mots de passes ne sont pas les mêmes.");
					errorList.add("Les deux mots de passes ne sont pas les mêmes.");
					
					
				} else {
					//System.out.println("Utilisateur bien enregistré");
					
					
					//On prepare notre objet pour effectuer la requete sql
					DatabaseHelper dbHelper = new DatabaseHelper();
					
					//On prepare le manager d'utilisateur
					UserManager uManager = new UserManager();
					
					User u = new User(login,password,lastname,firstname,nickname,picture);
					
					//Si l'utilisateur existe on renvois vers la page index.html
					if (uManager.IsUserIdExist(u)){
						errorList.add("L'utilisateur existe déjà");
					//Si non on l'ajoute à la bdd
					}else{
						uManager.AddUser(u);
					}
				}
				
				request.setAttribute("Errors", errorList);
				
				if(errorList.isEmpty() == false){		
					
					request.getRequestDispatcher("inscription.jsp").forward(request, response);
					
				}else{
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
