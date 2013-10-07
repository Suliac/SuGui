package Model;

public class Evaluation {
	
	/**************Attributs****************/	
	//Identifiant de l'utilisateur
	private String _evaUtilisateur;
	
	//Film auquel appartient la note.
	private String _evaFilm;
	
	//Note de l'�valuation (Obligatoire)
	private int _evaNote;
	
	//Titre de l'�valuation (Obligatoire)
	private String _evaTit;
	
	//Description de l'�valuation (Facultatif)
	private String _evaDes;
	
	/**************Accesseurs****************/	
	
	//Recup�re la note de l'�valuation
	public int get_evaNote() {
		return _evaNote;
	}
	
	//Met � jour la note 
	public void set_evaNote(int _evaNote) {
		this._evaNote = _evaNote;
	}
	
	
	//R�cup�re le titre de l'�valuation
	public String get_evaTit() {
		return _evaTit;
	}
	
	//Met � jour le titre
	public void set_evaTit(String _evaTit) {
		this._evaTit = _evaTit;
	}
	
	
	//R�cup�re la description
	public String get_evaDes() {
		return _evaDes;
	}
	
	//Met � jour la description
	public void set_evaDes(String _evaDes) {
		this._evaDes = _evaDes;
	}
	
	//R�cup�re l'identifiant de l'utilisateur qui a cr�er cette note.
	public String get_evaUtilisateur() {
		return _evaUtilisateur;
	}
	
	//Met � jour l'indentifiant de l'utilisateur qui a cr�er cette note.
	public void set_evaUtilisateur(String _evaUtilisateur) {
		this._evaUtilisateur = _evaUtilisateur;
	}

	//R�cup�re le film
	public String get_evaFilm() {
		return _evaFilm;
	}
	// Met � jour le film
	public void set_evaFilm(String _evaFilm) {
		this._evaFilm = _evaFilm;
	}

	
	/**************Constructeurs****************/	
	
	//Constructeur par d�faut
	public Evaluation() {
		this._evaNote = 0;
		this._evaTit = null;
		this._evaDes = null;
	}
	
	//Constructeur d'�valuation avec une note et un titre (comme la description est facultative)
	public Evaluation(int _evaNote, String _evaTit) {
		this._evaNote = _evaNote;
		this._evaTit = _evaTit;
	}	
	
	//Constructeur d'�valuation avec une note, un titre et une description
	public Evaluation(int _evaNote, String _evaTit, String _evaDes) {
		this._evaNote = _evaNote;
		this._evaTit = _evaTit;
		this._evaDes = _evaDes;
	}
	
	//Constructeur d'�valuation avec l'identifiant de l'utilisateur, le nom du film , une notre, un titre et une description.
	public Evaluation(String _evaUtilisateur, String _evaFilm, int _evaNote,
			String _evaTit, String _evaDes) {
		super();
		this._evaUtilisateur = _evaUtilisateur;
		this._evaFilm = _evaFilm;
		this._evaNote = _evaNote;
		this._evaTit = _evaTit;
		this._evaDes = _evaDes;
	}
	
	/**************M�thodes****************/	
	
	
}
