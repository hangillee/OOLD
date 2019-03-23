
public class StoryStage {
	public void Stage01() {
		PrintMethods.ClearScreen();
		Player player = Player.getInstance();
		int playerDefend = player.getDefend();
		
		Enemy dirtGolem = new Enemy(100, playerDefend+10, 10, "DIRT GOLEM"); //ÁøÈë °ñ·½ Ã¼·Â:100, °ø°Ý·Â:ÇÃ·¹ÀÌ¾î ¹æ¾î·Â + 10, ¹æ¾î·Â:10
		CharacterAct characterAct = new CharacterAct();
		
		int enemyHP, enemyAT, enemyDF;
		String enemyNAME;
		
		enemyHP = dirtGolem.getHealth(); //Ã³À½ ÁøÈë °ñ·½ Ã¼·Â µ¥ÀÌÅÍ ¹Þ¾Æ¿È
		enemyAT = dirtGolem.getAttack();
		enemyDF = dirtGolem.getDefend();
		enemyNAME = dirtGolem.getName();
		
		System.out.println("============== Stage 01 ==============");
		System.out.println("");
		System.out.println("              DIRT GOLEM              ");
		System.out.println("");
		System.out.println("======================================");
		System.out.println("");
		System.out.println("DIRT GOLEM BLOCKS YOUR WAY!");
		System.out.println("¢º " + enemyNAME + "'s HP : " + enemyHP); //ÁøÈë °ñ·½ Ã¼·Â
		System.out.println("¢º " + enemyNAME + "'s STR : " + enemyAT); //ÁøÈë °ñ·½ °ø°Ý·Â
		System.out.println("¢º " + enemyNAME + "'s DEF : " + enemyDF); //ÁøÈë °ñ·½ ¹æ¾î·Â
		System.out.println("");
		
		characterAct.PlayerAct(enemyHP, enemyAT, enemyDF, enemyNAME);
		Stage02();
	}
	public void Stage02() {
		PrintMethods.ClearScreen();
		Player player = Player.getInstance();
		int playerDefend = player.getDefend();
		
		Enemy stoneGolem = new Enemy(200, playerDefend+15, 20, "STONE GOLEM"); //¹ÙÀ§ °ñ·½ Ã¼·Â:200, °ø°Ý·Â:ÇÃ·¹ÀÌ¾î ¹æ¾î·Â+15, ¹æ¾î·Â:20
		CharacterAct characterAct = new CharacterAct();
		
		int enemyHP, enemyAT, enemyDF;
		String enemyNAME;
		
		enemyHP = stoneGolem.getHealth(); //Ã³À½ ¹ÙÀ§ °ñ·½ Ã¼·Â µ¥ÀÌÅÍ ¹Þ¾Æ¿È
		enemyAT = stoneGolem.getAttack();
		enemyDF = stoneGolem.getDefend();
		enemyNAME = stoneGolem.getName();
		
		System.out.println("============== Stage 02 ==============");
		System.out.println("");
		System.out.println("             STONE GOLEM              ");
		System.out.println("");
		System.out.println("======================================");
		System.out.println("");
		System.out.println(enemyNAME + " BLOCKS YOUR WAY!");
		System.out.println("¢º " + enemyNAME + "'s HP : " + enemyHP); //¹ÙÀ§ °ñ·½ Ã¼·Â
		System.out.println("¢º " + enemyNAME + "'s STR : " + enemyAT); //¹ÙÀ§ °ñ·½ °ø°Ý·Â
		System.out.println("¢º " + enemyNAME + "'s DEF : " + enemyDF); //¹ÙÀ§ °ñ·½ ¹æ¾î·Â
		System.out.println("");
		
		characterAct.PlayerAct(enemyHP, enemyAT, enemyDF, enemyNAME);
		//Stage03();
	}
}
