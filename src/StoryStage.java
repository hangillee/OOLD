import java.util.Scanner;

public class StoryStage {
	public void Stage01() {
		PrintMethods.ClearScreen();
		Scanner scan = new Scanner(System.in);
		EnemyInfo dirtGolem = new EnemyInfo(100, 20, 10); //ÁøÈë °ñ·½ Ã¼·Â 100, °ø°Ý·Â 20, ¹æ¾î·Â 20
		
		char selectAS;
		
		System.out.println("============== Stage 01 ==============");
		System.out.println("");
		System.out.println("              DIRT GOLEM              ");
		System.out.println("");
		System.out.println("======================================");
		System.out.println("");
		System.out.println("DIRT GOLEM BLOCKS YOUR WAY!");
		System.out.println("DIRT GOLEM's HP : " + dirtGolem.getHealth());
		System.out.println("DIRT GOLEM's STR : " + dirtGolem.getAttack());
		System.out.println("DIRT GOLEM's DEF : " + dirtGolem.getDefend());
		System.out.println("");
		System.out.println("What should you do?");
		System.out.println("A. NORMAL ATTACK");
		System.out.println("S. SKILL ATTACK");
		selectAS = scan.nextLine().charAt(0);
		
		
	}
}
