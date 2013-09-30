package Categorie;

public class Categorie {
	
	/**************Attributs****************/	
	//Nom de la cat�gorie
	private	String _catName;

	//Description de la cat�gorie
	private String _catDesc;
		
	/**************Accesseurs****************/	
	
	//R�cup�re le nom de la cat�gorie
	public String get_catName() {
		return _catName;
	}
	
	//Met � jour le nom avec la valeur envoy�e
	public void set_catName(String _catName) {
		this._catName = _catName;
	}

	
	//R�cup�re la description de la cat�gorie
	public String get_catDesc() {
		return _catDesc;
	}

	//Met � jour la description de la cat�gorie
	public void set_catDesc(String _catDesc) {
		this._catDesc = _catDesc;
	}
	
	/**************Constructeurs****************/	
	
	//Constructeur par d�faut
	public Categorie() {
		super();
		this._catName = null;
		this._catDesc = null;
	}
	
	//Constructeur de la cat�gorie � l'aide du nom et de la descritpion (cette derni�re ne peut pas �tre null comme le nom )
	public Categorie(String _catName, String _catDesc) {
		this._catName = _catName;
		this._catDesc = _catDesc;
	}
	

}
