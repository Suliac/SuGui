package Object;

import java.util.Date;

public class Film {

	/**************Attributs****************/
	
	//Nom du film (Obligatoire)
	private String _filmName;

	//Description du film (Obligatoire)
	private String _filmDesc;
	
	//Nom du r�alisteur du film (Facultatif)
	private String _filmReal;
	
	//Date de sortie (Facultatif)
	private Date _filmDateSortie;
	
	
	/**************Accesseurs****************/
	
	//R�cup�re et met � jour le nom du film
	public String get_filmName() {
		return _filmName;
	}
	public void set_filmName(String _filmName) {
		this._filmName = _filmName;
	}
	
	//r�cup�re et met � jour la description du film
	public String get_filmDesc() {
		return _filmDesc;
	}
	public void set_filmDesc(String _filmDesc) {
		this._filmDesc = _filmDesc;
	}
	
	//R�cup�re et met � jour le realisateur du film
	public String get_filmReal() {
		return _filmReal;
	}
	public void set_filmReal(String _filmReal) {
		this._filmReal = _filmReal;
	}
	
	//R�cup�re et met � jour la date de sortie du film
	public Date get_filmDateSortie() {
		return _filmDateSortie;
	}
	public void set_filmDateSortie(Date _filmDateSortie) {
		this._filmDateSortie = _filmDateSortie;
	}

	
	/**************Constructeurs****************/
	
	//Constructeur par d�faut
	public Film() {
		this._filmName = null;
		this._filmDesc = null;
		this._filmReal = null;
		this._filmDateSortie = null;
	}

	//COnstructeur de film avec un nom et une description
	public Film(String _filmName, String _filmDesc) {

		this._filmName = _filmName;
		this._filmDesc = _filmDesc;
		this._filmReal = null;
		this._filmDateSortie = null;
	}

	//Constructeur de film avec un nom, une descrption, un nom de r�alisateur et une date de sortie
	public Film(String _filmName, String _filmDesc, String _filmReal,
			Date _filmDateSortie) {

		this._filmName = _filmName;
		this._filmDesc = _filmDesc;
		this._filmReal = _filmReal;
		this._filmDateSortie = _filmDateSortie;
	}
		
	
	
	
}
