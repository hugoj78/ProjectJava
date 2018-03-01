import java.util.ArrayList;
import java.util.Collections;

public class Random {

	public static void main(String[] args) {
		
	}
	
	public int[] Alea(int nb_questions){
		int[] rand = new int[nb_questions];
		
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        for (int i=0; i<nb_questions ; i++) {
	            list.add(new Integer(i));
	        }
	        Collections.shuffle(list);
	        for (int i=0; i<rand.length; i++) {
	        	
	        	rand[i] = list.get(i);
	        	
	            //System.out.println(rand[i]);
	        }
	        return rand;
	    
	}
}