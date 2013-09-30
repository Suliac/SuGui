package Evaluation;

public class Evaluation {
	
	/**************Attributs****************/	
	
	//Note de l'évaluation (Obligatoire)
	private int _evaNote;
	
	//Titre de l'évaluation (Obligatoire)
	private String _evaTit;
	
	//Description de l'évaluation (Facultatif)
	private String _evaDes;
	
	/**************Accesseurs****************/	
	
	//Recupère la note de l'évaluation
	public int get_evaNote() {
		return _evaNote;
	}
	
	//Met à jour la note 
	public void set_evaNote(int _evaNote) {
		this._evaNote = _evaNote;
	}
	
	
	//Récupère le titre de l'évaluation
	public String get_evaTit() {
		return _evaTit;
	}
	
	//Met à jour le titre
	public void set_evaTit(String _evaTit) {
		this._evaTit = _evaTit;
	}
	
	
	//Récupère la description
	public String get_evaDes() {
		return _evaDes;
	}
	
	//Met à jour la description
	public void set_evaDes(String _evaDes) {
		this._evaDes = _evaDes;
	}
	
	/**************Constructeurs****************/	
	
	//Constructeur par défaut
	public Evaluation() {
		this._evaNote = 0;
		this._evaTit = null;
		this._evaDes = null;
	}
	
	//Constructeur d'évaluation avec une note et un titre (comme la description est facultative)
	public Evaluation(int _evaNote, String _evaTit) {
		this._evaNote = _evaNote;
		this._evaTit = _evaTit;
	}	
	
	//Constructeur d'évaluation avec une note, un titre et une description
	public Evaluation(int _evaNote, String _evaTit, String _evaDes) {
		this._evaNote = _evaNote;
		this._evaTit = _evaTit;
		this._evaDes = _evaDes;
	}
	
	/**************Méthodes****************/	
	
	
}
