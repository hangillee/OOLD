import java.util.Scanner;

public class PrintMethods {
	private static final Scanner scan = new Scanner(System.in);
	public static void ClearScreen() { //C�� system("cls"); ����� ���� ����, ���� �ʿ�.
	    for (int i = 0; i < 80; i++) {
	      System.out.println("");
	    }
	}
	
	public static void PressEnterToContinue() { //����Ű �Է����� ���� ������ ���� �޼ҵ�
		System.out.println("    Press Enter to continue...");
		String insert = scan.nextLine();
		
		while(true) { //EnterŰ�� ���� ������ ���� ����
			if(insert.length() == 0) {
				break;
			}
			else {
				System.out.println("  Please Press ENTER to continue!");
				insert = scan.nextLine();
			}
		}
	}
	
	public static void PrintIntro() { //��Ʈ�� ��� �޼ҵ�
		System.out.println("========================================");
		System.out.println("=                                      =");
		System.out.println("=   Only One Life Dungeon              =");
		System.out.println("=                                      =");
		System.out.println("=                   Made by Basileus   =");
		System.out.println("=                                      =");
		System.out.println("========================================");
	}
	
	public void PrintPrologue(){ //���ѷα� ��� �޼ҵ�
		//ClearScreen();
		StoryStage storyStage = new StoryStage();
		System.out.println("=============== Prologue ===============");
		System.out.println("=                                      =");
		System.out.println("= Only one life is allowed to warrior! =");
		System.out.println("=   Never make a mistake in DUNGEON!   =");
		System.out.println("=                                      =");
		System.out.println("========================================");
		System.out.println("");
		System.out.println("       Press Enter to continue...       ");
		String insert = scan.nextLine();
		insert = scan.nextLine(); //nextInt();�� ���๮�� ���� �ذ��� ���� �߰� nextLine(); ������ prologue �ٷ� �����
		
		while(true) { //EnterŰ�� ���� ������ ���� ����
			if(insert.length() == 0) {
				storyStage.Stage01();
				break;
			}
			else {
				System.out.println("     Please Press ENTER to continue!     ");
				insert = scan.nextLine();
			}
		}
	}
	
	public void PrintMainPage() { //���� ȭ�� - ���� ��� �޼ҵ�
		int selectMenu = 0; //���� ȭ�� �������� ����
		char selectYN; //���� ���� Ȯ�� �������� ����
		
		System.out.println("");
		System.out.println("1. Game Start"); //������ ���
		System.out.println("2. Exit Game");
		System.out.println("");
		System.out.print("�� Select : ");
		while(!scan.hasNextInt()) { //���� Ŀ�ǵ� �Է� Ȯ�� ���ڰ� �ƴ� �� while�� ����
			scan.next();
			System.out.println("");
			System.out.println("===================================");
			System.out.println("    Please Enter Right Command!    ");
			System.out.println("===================================");
			System.out.println("");
			System.out.println("1. Game Start"); //������ ���
			System.out.println("2. Exit Game");
			System.out.println("");
			System.out.print("�� Select : ");
		}
		selectMenu = scan.nextInt();
		
		while (true) { //���� �޴� ������
			if(selectMenu == 1) {
				Player player = Player.getInstance();
				player.SetPlayerHealth();
				player.SetPlayerName();
				player.SetPlayerAttackStat();
				player.SetPlayerDefendStat();
				player.SetPlayerDexterity();
				PrintPrologue(); //PrintPrologue�޼ҵ� ȣ��
				break;
			} else if(selectMenu == 2) {
				System.out.println("");
				System.out.print("�� Do you want to Exit game?(Y or N) : ");	
				selectYN = scan.next().charAt(0);
				if(selectYN == 'Y' || selectYN == 'y') {
					System.exit(0);
				} else if(selectYN == 'N' || selectYN == 'n') {
					PrintMainPage(); //�ٽ� ���� ȭ�� ���
					break;
				} else {
					System.out.println("");
					System.out.println("===================================");
					System.out.println("    Please Enter Right Command!    ");
					System.out.println("===================================");
				}
			} else {
				System.out.println("");
				System.out.println("===================================");
				System.out.println("    Please Enter Right Command!    ");
				System.out.println("===================================");
				PrintMainPage();
				break;
			}
		}
	}
	public static void PrintPlayerStat() {
		Player player = Player.getInstance();
		
		String playerName = player.getName();
		int playerHP = player.getHealth();
		int playerAT = player.getAttack();
		int playerDF = player.getDefend();
		int playerDX = player.getDexterity();
		
		System.out.println("�� " + playerName + "'s HP : " + playerHP); //�÷��̾� ���ݷ�
		System.out.println("�� " + playerName + "'s STR : " + playerAT); //�÷��̾� ���ݷ�
		System.out.println("�� " + playerName + "'s DEF : " + playerDF); //�÷��̾� ����
		System.out.println("�� " + playerName + "'s DEX : " + playerDX); //�÷��̾� ��ø��
		System.out.println("");
	}
	public static void PrintEnemyStat(Enemy enemy) {
		//�� ���� ������ �޾ƿ�
		int enemyHP = enemy.getHealth(); 
		int enemyAT = enemy.getAttack();
		int enemyDF = enemy.getDefend();
		int enemyDX = enemy.getDexterity();
		String enemyNAME = enemy.getName();
		
		System.out.println("�� " + enemyNAME + "'s HP : " + enemyHP);
		System.out.println("�� " + enemyNAME + "'s STR : " + enemyAT);
		System.out.println("�� " + enemyNAME + "'s DEF : " + enemyDF);
		System.out.println("�� " + enemyNAME + "'s DEX : " + enemyDX);
		System.out.println("");
	}
	//Stage Ŭ���� �� ��� �޼ҵ�
	public static void StageClear(String enemyNAME) {
		Player player = Player.getInstance();
		
		player.setHealth(100); //�÷��̾� Ŭ���� �� ü�� �ʱ�ȭ
		System.out.println("==============================");
		System.out.println("                              ");
		System.out.println("  " + enemyNAME + " DOWN! YOU WIN!  ");
		System.out.println("                              ");
		System.out.println("==============================");
		System.out.println("");
	}
	//���� ���� �� ��� �޼ҵ�
	public static void GameOver() {
		String selectYN;
		
		System.out.println("==============================");
		System.out.println("=                            =");
		System.out.println("=    GAME OVER! YOU DIED!    =");
		System.out.println("=        Retry? (Y/N)        =");
		System.out.println("=                            =");
		System.out.println("==============================");
		System.out.println("");
		while(true) {
			System.out.print("Select : ");
			selectYN = scan.nextLine();
			
			if(selectYN.equals("Y") || selectYN.equals("y")) {
				Player.maximumstat = 50; //���� ����Ʈ �ʱ�ȭ
				PrintMethods.ClearScreen();
				MainPage.main(null); //�ٽ� ����
				break;
			} else if(selectYN.equals("N") || selectYN.equals("n")) {
				System.out.println("");
				System.out.println("===================================");
				System.out.println("    Exit Game. Try Again Later!  ");
				System.out.println("===================================");
				System.exit(0);
			} else if(selectYN.equals("")) {
				System.out.println("�� Please Enter right command!");
				System.out.println("");
			} else {
				System.out.println("�� Please Enter right command!");
				System.out.println("");
			}
		}
	}
}
