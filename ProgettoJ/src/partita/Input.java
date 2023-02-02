package partita;

import java.io.IOException;
import java.util.Scanner;

public class Input {
	
	private Scanner sc;
	private static Input input = null;
	
	private Input()
	{
		sc = new Scanner(System.in);
	}
	
	public static Input getInput()
	{
		if (input == null) input = new Input();
		return input;
	}
	
	public int readInt()
	{
		int i = sc.nextInt();
		//sc.close();

		return i;		
	}

}
