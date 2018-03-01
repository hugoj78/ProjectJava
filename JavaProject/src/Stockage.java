
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;
public class Stockage {

	// On stocke dans 4 tableau les 4 mots et la reponse a la meme position dans le tableau pr les rappeler plus tard
	private String Mots1[] = {"Poil","Machine","Monstres", "Table", "Enfant", "Mythologie", "Geant", "Miserable", "Tele-Realite", "Faucon", "Boisson", "Sport", "Pouvoir", "Japon", "Cascade", "Rhum", "Senat", "Pain", "Effort", "Macedoine", "Soleil", "Question", "Foret", "Verre", "Villageois", "Artiste", "Metro", "Lame","Competition"};
	private String Mots2[] = {"Prehistoire","Capsule","Jeu video", "Livre", "Princesse", "Odyssee", " Recherche", "Leopoldine", "Rap", "Sabre", "Patate", "Voiture", "Influence", "Voyage", "Chaine", "Compas", "Rome", "Vin", "Exercice", "Conquete", "Seisme", "Repetition", "Feu", "Petit", "Voyante", "Statue", "Boulot", "Capuche","Coubertin"};
	private String Mots3[] = {"Defense","Energie","Tueur", "Tableau", "Conte", "Bateau", "Firme", "Besacon", "Fesses", "Guerre", "L'Est", "Circuit", "Tour", "Combat", "Famille", "Coffre", "Epee", "Fromage", "Transpiration", "Jeune", "Tsunami", "Drole", "Robin", "Jetable", "Loup-Garou", "Musee", "Manger", "Pomme","Sport"};
	private String Mots4[] = {"Gros","Boisson","Mutation", "Savoir", "Dessin", "Heros", "Internet", "Senateur","Sex-tape", "Galaxie", "Fete", "Moteur", "Football", "Creature", "Turbo", "Trahison", "Film", "Paris", "competition", "Grand", "Blanc", "France 3", "Palissade", "Plastique", "Nuit", "Paris", "Dodo", "Discretion","Internationale"};
	private String Reponse[] = {"mammouth", "cafe", "the witcher", "ecole", "disney", "ulysse", "google", "victor hugo", "kim kardashian", "star wars", "vodka", "formule 1", "qatar", "pokemon", "fast and furious", "pirate des caraibes", "gladiateur", "france", "sport", "alexandre", "japon", "mer noire", "bois", "gobelet", "thiercelieux", "rodin", "quotidien", "assasin's creed","jo"};

	
	private JFrame fenetre = new JFrame();
	private JPanel Panel1 = new JPanel();

	private JLabel consigne =new JLabel();
	private JButton start =new JButton("start");
	
	private JLabel mot1 =new JLabel();
	private JLabel mot2 =new JLabel();
	private JLabel mot3 =new JLabel();
	private JLabel mot4 =new JLabel();
	private JLabel lettres =new JLabel();
	private JTextField input = new JTextField("");
	private JLabel vide = new JLabel();
	
	private JLabel winner = new JLabel();
	public String joueur_reponse = new String();
	
	private void init_elements(){

		CardLayout cl = new CardLayout();
		JPanel content = new JPanel();
		  //Liste des noms de nos conteneurs pour la pile de cartes
		  String[] listContent = {"CARD_1", "CARD_2"};
		  int indice = 0;
		
		//creation de la fenetre

		//DÃ©finit un titre pour notre fenetre
		fenetre.setTitle("Jeu 4 mots pour 1 mot");
		//DÃ©finit sa taille : 400 pixels de large et 100 pixels de haut
		fenetre.setSize(1000, 600);
		//Nous demandons maintenant a  notre objet de se positionner au centre
		fenetre.setLocationRelativeTo(null);
		//Termine le processus lorsqu'on clique sur la croix rouge
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Et enfin, la rendre visible
		fenetre.setVisible(true);
		fenetre.setLayout(cl);
		
		//On crée trois conteneurs de couleur différente
	    JPanel card1 = new JPanel();

		card1.setLayout( new GridLayout(2,1));
	    
	    card1.add(consigne, BorderLayout.CENTER);
	    //set text
  		consigne.setText("<html>CONSIGNE : 4 mots vont vous être présenter vous devez retrouver le mot correspondant (Ne mettez pas d'accent, il comptera comme une faute)");
  		//color
		consigne.setBackground(Color.CYAN);
		//font color
		consigne.setForeground(Color.BLUE);
		consigne.setOpaque(true);
		consigne.setVisible(true);
		card1.add(start, BorderLayout.SOUTH);
		start.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		          //Via cette instruction, on passe au prochain conteneur de la pile
		          cl.next(content);
		        }
		      });
		start.setVisible(true);
		
	    JPanel card2 = new JPanel();

		card2.setLayout( new GridLayout(4,2));
	    
	    card2.add(mot1);
		mot1.setBackground(Color.CYAN);
		mot1.setOpaque(true);
		mot1.setVisible(true);
		card2.add(mot2);
		mot2.setBackground(Color.CYAN);
		mot2.setOpaque(true);
		mot2.setVisible(true);
		card2.add(mot3);
		mot3.setBackground(Color.CYAN);
		mot3.setOpaque(true);
		mot3.setVisible(true);
		card2.add(mot4);
		mot4.setBackground(Color.CYAN);
		mot4.setOpaque(true);
		mot4.setVisible(true);
		card2.add(lettres);
		lettres.setBackground(Color.CYAN);
		lettres.setOpaque(true);
		lettres.setVisible(true);
		card2.add(input);
		input.setVisible(true);
	    
		card2.add(winner);
		winner.setBackground(Color.CYAN);
		winner.setOpaque(true);
		winner.setVisible(true);
		card2.add(vide);
		vide.setBackground(Color.CYAN);
		vide.setOpaque(true);
		vide.setVisible(true);
		

	    //On définit le layout
	    content.setLayout(cl);
	    //On ajoute les cartes à la pile avec un nom pour les retrouver
	    content.add(card1, listContent[0]);
	    content.add(card2, listContent[1]);

	    fenetre.getContentPane().add(content);
	    fenetre.setVisible(true);

		//fin de l'interface
	}
 	public void start() throws InterruptedException{
		// on genere l'ordre dans lequel sera affiche chaque question dans le tableau rand_order
		Random rand = new Random();
		int[] rand_order = rand.Alea(Reponse.length);


		// On commence a  a = 0 (a modifier pr l'alea plus tard avec un tableau, etc) puis on passe au autres questions.
		int joueur[] = {5,5};
		int actual =0;
		for(int i = 0; Reponse.length > i; i++){
			
			if (i == 30) {
				i = 0;
			}
			
			// On affiche les 4 mots
			mot1.setText(Mots1[rand_order[i]]);
			mot2.setText(Mots2[rand_order[i]]);
			mot3.setText(Mots3[rand_order[i]]);
			mot4.setText(Mots4[rand_order[i]]);

			Cryptage cr = new Cryptage();
			String letter[] = cr.cryptage(Reponse[rand_order[i]]);
			String rep="";
			for(int j = 0; j < letter.length; j++){
				rep+=(letter[j]);
				rep+=" ";
			}
			//on affiche les lettres
			lettres.setText(rep);

			// On demande la reponse au joueur et le programme attent que le joueur repond

			synchronized (Stockage.this){
				try{
					Stockage.this.wait();
				}
				catch (InterruptedException e){
					e.printStackTrace();
				}
				if (input.getText().equals(Reponse[rand_order[i]])){
					//faire qqc
					input.setText("");
					if (actual==0){
						actual =1;
					}
					else {
						actual =0;
					}
					continue;
				}
				else {
					//faire autre chose
					joueur[actual]-=1;
					input.setText("");
					if (joueur[actual]==0){
						mot1.hide();
						mot2.hide();
						mot3.hide();
						mot4.hide();
						lettres.hide();
						input.hide();

						if (actual==0) {
							winner.setText("<html> Joueur 2 win</html>");//balise html pour le resize auto
						}
						else {
							winner.setText("<html> Joueur 1 win</html>");
						}
						winner.show();
						Thread.sleep(5000);
						winner.hide();
						vide.hide();
						fenetre.dispose();
						break;
					}
					continue;
				}

			}
		}

	}

	// methode necessaire au lancement du thread
	public class FrameRunnable implements Runnable{

		@Override
		public void run() {
			try {
				start();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void question() {

		init_elements();
		//on prend la reponse du joueur en compte
		input.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				synchronized (Stockage.this){
					joueur_reponse =input.getText();
					Stockage.this.notify();
				}
			}
		});
		//les action quand on appui sur start
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				consigne.hide();
				start.hide();
				input.show();
				mot1.show();
				mot2.show();
				mot3.show();
				mot4.show();
				lettres.show();
				new Thread(new FrameRunnable()).start();//sert a faire plusieur action en meme temps
			}
		});



	}
	
}
