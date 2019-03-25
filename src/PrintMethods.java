import java.util.Scanner;

public class PrintMethods {
	private static final Scanner scan = new Scanner(System.in);
	public static void ClearScreen() { //C�� system("cls"); ����� ���� ����, ���� �ʿ�.
	    for (int i = 0; i < 80; i++) {
	      System.out.println("");
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
		insert = scan.nextLine(); //nextInt();�� ���๮�� ���� �ذ��� ���� �߰� nextLine();
		
		while(true) { //EnterŰ�� ���� ������ ���� ����
			if(insert.length() == 0) {
				storyStage.Stage01();
				//scan.close();
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
					System.out.println("�� Please press right command.");
					System.out.println("");
				}
			} else {
				System.out.println("�� Please press right command.");
				System.out.println("");
			}
		}
	}
}
