package warcraftMain;

import java.util.ArrayList;
import java.util.List;
import java.awt.Font;

public class Terminal {

    private List<Infos> infosToDraw = new ArrayList<Infos>();		// Liste des information a afficher 
    private int time ;                                              // Repère chronologique de la classe Wolrd

    /**
	 * Cette classe permet un gestion simple des informations a afficher 
	 */
	private static class Infos{
		private int time ;				
		private String message;

		public int getTime() {
			return time;
		}
		public String getMessage() {
			return message;
		}

		public Infos(String message , int time){
			this.time = time ;
			this.message = message ;
		}	
	}



    /**
	 * Affiche les quatres derniers messages destine au joueur (comme dans la console)
	 * 
	 * 	- Affiche les messages sous forme de liste (le dernier de la liste en premier, l'avant dernier en second, ect)
	 * 	- Si le message est trop long il est affiche sur deux lignes
	 */
	public void drawTerminal() {
        StdDraw.picture(0.077, 0.90, "images/SupportDrawInfos.png" , 0.16 , 0.3);
		StdDraw.setPenColor(StdDraw.WHITE);
		Font font = new Font("Average", Font.ITALIC, 14);
		StdDraw.setFont(font);
		
		if((infosToDraw.size() - 1) > -1) {
			if(infosToDraw.get(infosToDraw.size() - 1).getMessage().length() > 35){
				StdDraw.text(0.075, 0.8 , String.valueOf(infosToDraw.get(infosToDraw.size() - 1).getMessage().substring(35)));
				StdDraw.text(0.075, 0.815 , String.valueOf(infosToDraw.get(infosToDraw.size() - 1).getMessage().substring(0 , 35)));
			}
			else StdDraw.text(0.075, 0.815 , String.valueOf(infosToDraw.get(infosToDraw.size() - 1).getMessage()));
		}

		if((infosToDraw.size() - 2) > -1) {
			if(infosToDraw.get(infosToDraw.size() - 2).getMessage().length() > 35){
				StdDraw.text(0.075, 0.835 , String.valueOf(infosToDraw.get(infosToDraw.size() - 2).getMessage().substring(35)));
				StdDraw.text(0.075, 0.85 , String.valueOf(infosToDraw.get(infosToDraw.size() - 2).getMessage().substring(0 , 35)));
			}
			else StdDraw.text(0.075, 0.85 , String.valueOf(infosToDraw.get(infosToDraw.size() - 2).getMessage()));
		}
		
		if((infosToDraw.size() - 3) > -1) {
			if(infosToDraw.get(infosToDraw.size() - 3).getMessage().length() > 35){
				StdDraw.text(0.075, 0.87 , String.valueOf(infosToDraw.get(infosToDraw.size() - 3).getMessage().substring(35)));
				StdDraw.text(0.075, 0.885 , String.valueOf(infosToDraw.get(infosToDraw.size() - 3).getMessage().substring(0 , 35)));
			}
			else StdDraw.text(0.075, 0.885 , String.valueOf(infosToDraw.get(infosToDraw.size() - 3).getMessage()));
		}
		
		if((infosToDraw.size() - 4) > -1) {
			if(infosToDraw.get(infosToDraw.size() - 4).getMessage().length() > 35){
				StdDraw.text(0.075, 0.905 , String.valueOf(infosToDraw.get(infosToDraw.size() - 4).getMessage().substring(35)));
				StdDraw.text(0.075, 0.92 , String.valueOf(infosToDraw.get(infosToDraw.size() - 4).getMessage().substring(0 , 35)));
			}
			else StdDraw.text(0.075, 0.92 , String.valueOf(infosToDraw.get(infosToDraw.size() - 4).getMessage()));
		}
    }

    /**
	 * Ajoute un message ainsi que le moment auquel il a été émis 
	 * NOTE :
	 * Le message n'est pas ajouté si il a deja été emis lors des 10 dernier update  
	 */
	public void addInfo(String message){
		boolean add = true ;
		for(Infos i : infosToDraw){
			if(i.getMessage().equals(message) && time - i.getTime() < 10) add = false ; 
		}
		if(add)infosToDraw.add(new Infos(message , time));
	}
    

    /**
	 * Met a jour Terminal
	 */
	public void updateTerminal(int time){
        this.time = time ;
        if(time%5==0) updateList();
        drawTerminal();
    }
    
     /**
	 * Supprime les messages d'informations au bout de 100 update
	 */
    public void updateList(){
        for(Infos i : infosToDraw){
			if((time - i.getTime()) > 100) {
				infosToDraw.remove(i);
				break;
			}
		}
    }
    
}
