package Utilisateurs;

public class User {
	
	/**************Attributs****************/
	
	//identifiant de l'utilisateur pour se connecter (Obligatoire)
	private String _idUser;

	//Mot de passe de l'utilisateur pour se connecter (Obligatoire)
	private String _passwdUser;
	
	//Nom de l'utilisateur (Obligatoire)
	private String _nameUser;
	//Prenom de l'utilisateur (Obligatoire)
	private String _fnameUser;
	//Pseudo de l'utilisateur (Obligatoire)
	private String _nnameUser;
	
	//Nom de l'image (avec extension) de l'utilisateur (Facultatif)
	private String _imgUser;

	
	/**************Accesseurs****************/
	
	//Récupère et met à jour l'ID
	public String get_idUser() {
		return _idUser;
	}
	public void set_idUser(String _idUser) {
		this._idUser = _idUser;
	}

	//Récupère et met à jour le mot de passe
	public String get_passwdUser() {
		return _passwdUser;
	}
	public void set_passwdUser(String _passwdUser) {
		this._passwdUser = _passwdUser;
	}

	//Récupère et met à jour le nom
	public String get_nameUser() {
		return _nameUser;
	}
	public void set_nameUser(String _nameUser) {
		this._nameUser = _nameUser;
	}

	//Récupère et met à jour le prenom
	public String get_fnameUser() {
		return _fnameUser;
	}
	public void set_fnameUser(String _fnameUser) {
		this._fnameUser = _fnameUser;
	}

	//Récupère et met à jour le pseudo
	public String get_nnameUser() {
		return _nnameUser;
	}
	public void set_nnameUser(String _nnameUser) {
		this._nnameUser = _nnameUser;
	}

	//Récupère et met à jour le nom de l'image
	public String get_imgUser() {
		return _imgUser;
	}
	public void set_imgUser(String _imgUser) {
		this._imgUser = _imgUser;
	}

	
	
	/**************Constructeurs****************/
	
	//constructeur par défaut
	public User() {
		this._idUser = null;
		this._passwdUser = null;
		this._nameUser = null;
		this._fnameUser = null;
		this._nnameUser = null;
		this._imgUser = null;
	}
	
	//Constructeur d'un utilisateur sans image
	public User(String _idUser, String _passwdUser, String _nameUser,
			String _fnameUser, String _nnameUser) {

		this._idUser = _idUser;
		this._passwdUser = _passwdUser;
		this._nameUser = _nameUser;
		this._fnameUser = _fnameUser;
		this._nnameUser = _nnameUser;
		this._imgUser = null;
	}
	
	//Constructeur d'un utilisateur avec image
	public User(String _idUser, String _passwdUser, String _nameUser,
			String _fnameUser, String _nnameUser, String _imgUser) {

		this._idUser = _idUser;
		this._passwdUser = _passwdUser;
		this._nameUser = _nameUser;
		this._fnameUser = _fnameUser;
		this._nnameUser = _nnameUser;
		this._imgUser = _imgUser;
	}
	
}
