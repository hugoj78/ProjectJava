
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;
public class Stockage {

	// On stocke dans 4 tableau les 4 mots et la reponse a la meme position dans le tableau pr les rappeler plus tard
	private String Mots1[] = {"Poil","Machine","Monstres", "Table", "Enfant", "Mythologie", "Géant", "Misérable", "Télé-Réalité", "Faucon", "Boisson", "Sport", "Pouvoir", "Japon", "Cascade", "Rhum", "Senat", "Pain", "Effort", "Macedoine", "Soleil", "Question", "Forêt", "Verre", "Villageois", "Artiste", "Metro", "Lame"};
	private String Mots2[] = {"Prehistoire","Capsule","Jeu video", "Livre", "Princesse", "Odyssée", " Recherche", "Leopoldine", "Rap", "Sabre", "Patate", "Voiture", "Influence", "Voyage", "Chaine", "Compas", "Rome", "Vin", "Exercice", "Conquête", "Seisme", "Répétition", "Feu", "Petit", "Voyante", "Statue", "Boulot", "Capuche"};
	private String Mots3[] = {"Defense","Energie","Tueur", "Tableau", "Conte", "Bateau", "Firme", "Besaçon", "Fesses", "Guerre", "L'Est", "Circuit", "Tour", "Combat", "Famille", "Coffre", "Epée", "Fromage", "Transpiration", "Jeune", "Tsunami", "Drôle", "Robin", "Jetable", "Loup-Garou", "Musée", "Manger", "Pomme"};
	private String Mots4[] = {"Gros","Boisson","Mutation", "Savoir", "Dessin", "Heros", "Internet", "Senateur","Sex-tape", "Galaxie", "Fête", "Moteur", "Football", "Créature", "Turbo", "Trahison", "Film", "Paris", "competition", "Grand", "Blanc", "France 3", "Palissade", "Plastique", "Nuit", "Paris", "Dodo", "Discrétion" };
	private String Reponse[] = {"mammouth", "cafe", "the witcher", "ecole", "disney", "ulysse", "google", "victor hugo", "kim kardashian", "star wars", "vodka", "formule 1", "qatar", "pokemon", "fast and furious", "pirates des caraibes", "gladiator", "france", "sport", "alexandre", "japon", "la mer noire", "bois", "gobelet", "thiercelieux", "rodin", "quotidien", "assassin's creed"};

	private JFrame fenetre = new JFrame();
	private JPanel Panel1 = new JPanel();

	private JLabel consigne =new JLabel();
	private JButton start =new JButton("start");
	
	private JTextField input = new JTextField("");
	private JLabel mot1 =new JLabel();
	private JLabel mot2 =new JLabel();
	private JLabel mot3 =new JLabel();
	private JLabel mot4 =new JLabel();
	private JLabel lettres =new JLabel();
	
	public String joueur_reponse = new String();
	private JLabel winner = new JLabel();
	private JLabel passage = new JLabel();
	private JLabel score = new JLabel();
	private JLabel passage2 = new JLabel();
	
	private void init_elements(){
		//crÃ©ation de la fenetre
		
		
		  
		//DÃ©finit un titre pour notre fenÃªtre
		fenetre.setTitle("Jeu 4 mots pour 1 mot");
		//DÃ©finit sa taille : 400 pixels de large et 100 pixels de haut
		fenetre.setSize(1000, 600);
		//Nous demandons maintenant Ã  notre objet de se positionner au centre
		fenetre.setLocationRelativeTo(null);
		//Termine le processus lorsqu'on clique sur la croix rouge
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Et enfin, la rendre visible
		fenetre.setVisible(true);
		fenetre.getContentPane().add(Panel1);

		//add element to panel
		Panel1.add(mot1);
		Panel1.add(mot2);
		Panel1.add(mot3);
		Panel1.add(mot4);
		Panel1.add(consigne);
		Panel1.add(start);
		Panel1.add(input);
		Panel1.add(lettres);
		Panel1.add(winner);
		Panel1.add(passage);
		Panel1.add(score);
		Panel1.add(passage2);

		//set text
		consigne.setText("<html>CONSIGNE : 4 mots vont vous être présenter vous devez retrouver le mot correspondant (Ne mettez pas d'accent, il comptera comme une faute).<br>"
				+ "Les joueurs ont 5 points. Vous perdez 1 point à chaque mauvaise réponse. A chaque bonne réponse, c'est à l'autre joueur de jouer.");

		Font f = new Font("Serif", Font.PLAIN, 36);
		consigne.setFont(f);
		mot1.setFont(f);
		mot2.setFont(f);
		mot3.setFont(f);
		mot4.setFont(f);
		lettres.setFont(f);
		winner.setFont(f);
		score.setFont(f);
		passage.setFont(f);
		passage2.setFont(f);
		
		//size
		input.setPreferredSize(new Dimension(300, 30));
		consigne.setPreferredSize(new Dimension(900, 500));
		mot1.setPreferredSize(new Dimension(300, 200));
		mot2.setPreferredSize(new Dimension(300, 200));
		mot3.setPreferredSize(new Dimension(300, 200));
		mot4.setPreferredSize(new Dimension(300, 200));
		lettres.setPreferredSize(new Dimension(300 ,200));
		winner.setPreferredSize(new Dimension(300,200));
		score.setPreferredSize(new Dimension(300,200));
		passage.setPreferredSize(new Dimension(300,200));
		passage2.setPreferredSize(new Dimension(300,200));


		//color
		consigne.setBackground(Color.WHITE);
		mot1.setBackground(Color.WHITE);
		mot2.setBackground(Color.WHITE);
		mot3.setBackground(Color.WHITE);
		mot4.setBackground(Color.WHITE);
		lettres.setBackground(Color.WHITE);
		winner.setBackground(Color.WHITE);

		//font color
		consigne.setForeground(Color.BLACK);
		score.setForeground(Color.RED);

		//set opaque
		winner.setOpaque(true);
		consigne.setOpaque(true);
		mot1.setOpaque(true);
		mot2.setOpaque(true);
		mot3.setOpaque(true);
		mot4.setOpaque(true);
		lettres.setOpaque(true);

		//set visible of not visible
		input.hide();
		mot1.hide();
		mot2.hide();
		mot3.hide();
		mot4.hide();
		lettres.hide();
		winner.hide();
		passage.hide();
		score.hide();
		passage2.hide();


		//fin de l'interface
	}
 	public void start() throws InterruptedException {
		// on gï¿½nere l'ordre dans lequel sera affichï¿½ chaque question dans le tableau rand_order
		Random rand = new Random();
		int[] rand_order = rand.Alea(Reponse.length);


		// On commence Ã  a = 0 (a modifier pr l'alea plus tard avec un tableau, etc) puis on passe au autres questions.
		int[] joueur = {5,5};
		int actual =0;

		for(int i = 0; Reponse.length > i; i++){

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

			// On demande la rÃ©ponse au joueur et le programme attent que le joueur rÃ©pond

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
						passage.setText("<html> passage au joueur 2 </html>");
						passage.show();
						Thread.sleep(2000);
						passage.hide();
					}
					else {
						actual =0;
						passage2.setText("<html> passage au joueur 1 </html>");
						passage2.show();
						Thread.sleep(2000);
						passage2.hide();
					}
					continue;
				}
				else {
					//faire autre chose
					joueur[actual]-=1;
					score.setText("<html> -1 point de vie </html>");
					score.show();
					Thread.sleep(2000);
					score.hide();
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
						Thread.sleep(3000);
						winner.hide();
						start.show();
						consigne.show();
						break;
					}
					continue;
				}

			}
		}

	}

	// mÃ©thode nÃ©cessaire au lancement du thread
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

				new Thread(new FrameRunnable()).start();//sert a faire plusieur action en mÃªme temps
			}
		});



	}
	
}
