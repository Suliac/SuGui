package Categorie;

public class Categorie {
	
	/**************Attributs****************/	
	//Nom de la catégorie
	private	String _catName;

	//Description de la catégorie
	private String _catDesc;
		
	/**************Accesseurs****************/	
	
	//Récupère le nom de la catégorie
	public String get_catName() {
		return _catName;
	}
	
	//Met à jour le nom avec la valeur envoyée
	public void set_catName(String _catName) {
		this._catName = _catName;
	}

	
	//Récupère la description de la catégorie
	public String get_catDesc() {
		return _catDesc;
	}

	//Met à jour la description de la catégorie
	public void set_catDesc(String _catDesc) {
		this._catDesc = _catDesc;
	}
	
	/**************Constructeurs****************/	
	
	//Constructeur par défaut
	public Categorie() {
		super();
		this._catName = null;
		this._catDesc = null;
	}
	
	//Constructeur de la catégorie à l'aide du nom et de la descritpion (cette dernière ne peut pas être null comme le nom )
	public Categorie(String _catName, String _catDesc) {
		this._catName = _catName;
		this._catDesc = _catDesc;
	}
	

}
