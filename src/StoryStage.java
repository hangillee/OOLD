import java.util.Scanner;

public class StoryStage {
	public void Prologue(){
		PrintMethods.ClearScreen();
		Scanner scan = new Scanner(System.in);
		System.out.println("=============== Prologue ===============");
		System.out.println("=                                      =");
		System.out.println("= Only one life is allowed to warrior! =");
		System.out.println("=   Never make a mistake in DUNGEON!   =");
		System.out.println("=                                      =");
		System.out.println("========================================");
		System.out.println("");
		System.out.println("       Press Enter to continue...       ");
		String insert = scan.nextLine();
		
		while(true) { //Enter키를 통해 진행을 위한 조건
			if(insert.length() == 0) {
				Stage01();
				scan.close();
				break;
			}
			else {
				System.out.println("     Please Press Enter to continue!     ");
				insert = scan.nextLine();
			}
		}
	}
	public void Stage01() {
		PrintMethods.ClearScreen();
		System.out.println("============== Stage 01 ==============");
		System.out.println("");
		System.out.println("              DIRT GOLEM              ");
		System.out.println("");
		System.out.println("======================================");
		
		
	}
}
