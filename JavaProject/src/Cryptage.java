import java.util.ArrayList;
import java.util.Collections;

public class Cryptage {
 
 
 public void main(String[] args) {
  //on fait appel à la fonction cryptage juste en dessous   
  //cryptage("Salut");  
 }
 
 public String[] cryptage(String reponse) {
  
  
  // la "reponse_crypt" c'est la liste des lettres avec la raponse cachée dedans (on peut modifier la taille suffit juste de changer le nombre)
  String[] reponse_crypt = new String[reponse.length() + 5];
  
  // l'alphabet dans le tableau sert à prendre des lettres au hasard et remplir notre "reponse_crypt avec
  String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
  
  // ici on split la réponse qui est un String à la base en un tableau dont chaque lettre remplit une case 
  
  String[] str = reponse.split("");
  
  // on prépare un tableau pour recevoir des nombres différents générés aléatoirement
  int[] key = new int[str.length];
  
  // partie du code pour que 2 nombres générés aléatoirement ne puissent pas être égaux
  ArrayList<Integer> crypt_key = new ArrayList<Integer>();
        for ( int i=1 ; i<reponse_crypt.length ; i++ ) {
            crypt_key.add(new Integer(i));
        }
        Collections.shuffle(crypt_key);
        for ( int i=0 ; i<str.length ; i++ ) {
         // on fait rentrer chaque valeur générée aléatoirement dans un tableau "key", qui est notre clé de cryptage
            key[i] = crypt_key.get(i);
            //on affiche la clé pour voir comment ca marche dans la console (on enlèvera plus tard)
            //System.out.print(key[i]);
        }
  
        // on prend notre "reponse_crypt" et on injecte une lettre aléatoire de notre tableau alphabet dans chaque case
  for ( int i=0 ; i<reponse_crypt.length ; i++ ) {
   int rand_alphabet = ( int )( Math.random() * ( 0 + alphabet.length ));
   reponse_crypt[i] = alphabet[rand_alphabet]; 
  }
  
  // on ajoute chaque lettre de notre réponse (qu'on avait transformé en tableau) à la place générée par notre clé de cryptage
  for ( int i=0 ; i < str.length ; i++ ){
   reponse_crypt[key[i]] = str[i];
  }   
        
  // saut de ligne
  //System.out.println();
  
  // on affiche la réponse secrète
  //for ( int i=0 ; i<str.length ; i++ ) {
  // System.out.print(str[i]);
  //
  //}
  
  // saut de ligne
  //System.out.println();
  
  // on affiche notre résultat final qui est l'ensemble des 10 lettres avec les lettres de notre réponse cachées aux positions données par la clé
  //for ( int i=0 ; i<reponse_crypt.length ; i++ ) {
  // System.out.print(reponse_crypt[i]);   
  //} 
  return reponse_crypt;
 }
}
