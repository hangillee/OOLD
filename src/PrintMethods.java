import java.util.Scanner;

public class PrintMethods {
	private static final Scanner scan = new Scanner(System.in);
	public static void ClearScreen() { //C의 system("cls"); 기능을 대충 구현, 개선 필요.
	    for (int i = 0; i < 80; i++) {
	      System.out.println("");
	    }
	}
	
	public static void PressEnterToContinue() { //엔터키 입력으로 게임 진행을 위한 메소드
		System.out.println("    Press Enter to continue...");
		String insert = scan.nextLine();
		
		while(true) { //Enter키를 통해 진행을 위한 조건
			if(insert.length() == 0) {
				break;
			}
			else {
				System.out.println("  Please Press ENTER to continue!");
				insert = scan.nextLine();
			}
		}
	}
	
	public static void PrintIntro() { //인트로 출력 메소드
		System.out.println("========================================");
		System.out.println("=                                      =");
		System.out.println("=   Only One Life Dungeon              =");
		System.out.println("=                                      =");
		System.out.println("=                   Made by Basileus   =");
		System.out.println("=                                      =");
		System.out.println("========================================");
	}
	
	public void PrintPrologue(){ //프롤로그 출력 메소드
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
		insert = scan.nextLine(); //nextInt();의 개행문자 문제 해결을 위한 추가 nextLine(); 없으면 prologue 바로 실행됨
		
		while(true) { //Enter키를 통해 진행을 위한 조건
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
	
	public void PrintMainPage() { //메인 화면 - 선택 출력 메소드
		int selectMenu = 0; //메인 화면 선택지용 변수
		char selectYN; //게임 종료 확인 선택지용 변수
		
		System.out.println("");
		System.out.println("1. Game Start"); //선택지 출력
		System.out.println("2. Exit Game");
		System.out.println("");
		System.out.print("▶ Select : ");
		while(!scan.hasNextInt()) { //숫자 커맨드 입력 확인 숫자가 아닐 시 while문 실행
			scan.next();
			System.out.println("");
			System.out.println("===================================");
			System.out.println("    Please Enter Right Command!    ");
			System.out.println("===================================");
			System.out.println("");
			System.out.println("1. Game Start"); //선택지 출력
			System.out.println("2. Exit Game");
			System.out.println("");
			System.out.print("▶ Select : ");
		}
		selectMenu = scan.nextInt();
		
		while (true) { //메인 메뉴 선택지
			if(selectMenu == 1) {
				Player player = Player.getInstance();
				player.SetPlayerHealth();
				player.SetPlayerName();
				player.SetPlayerAttackStat();
				player.SetPlayerDefendStat();
				player.SetPlayerDexterity();
				PrintPrologue(); //PrintPrologue메소드 호출
				break;
			} else if(selectMenu == 2) {
				System.out.println("");
				System.out.print("▶ Do you want to Exit game?(Y or N) : ");	
				selectYN = scan.next().charAt(0);
				if(selectYN == 'Y' || selectYN == 'y') {
					System.exit(0);
				} else if(selectYN == 'N' || selectYN == 'n') {
					PrintMainPage(); //다시 메인 화면 출력
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
		
		System.out.println("▶ " + playerName + "'s HP : " + playerHP); //플레이어 공격력
		System.out.println("▶ " + playerName + "'s STR : " + playerAT); //플레이어 공격력
		System.out.println("▶ " + playerName + "'s DEF : " + playerDF); //플레이어 방어력
		System.out.println("▶ " + playerName + "'s DEX : " + playerDX); //플레이어 민첩성
		System.out.println("");
	}
	public static void PrintEnemyStat(Enemy enemy) {
		//적 스탯 데이터 받아옴
		int enemyHP = enemy.getHealth(); 
		int enemyAT = enemy.getAttack();
		int enemyDF = enemy.getDefend();
		int enemyDX = enemy.getDexterity();
		String enemyNAME = enemy.getName();
		
		System.out.println("▶ " + enemyNAME + "'s HP : " + enemyHP);
		System.out.println("▶ " + enemyNAME + "'s STR : " + enemyAT);
		System.out.println("▶ " + enemyNAME + "'s DEF : " + enemyDF);
		System.out.println("▶ " + enemyNAME + "'s DEX : " + enemyDX);
		System.out.println("");
	}
	//Stage 클리어 시 출력 메소드
	public static void StageClear(String enemyNAME) {
		Player player = Player.getInstance();
		
		player.setHealth(100); //플레이어 클리어 후 체력 초기화
		System.out.println("==============================");
		System.out.println("                              ");
		System.out.println("  " + enemyNAME + " DOWN! YOU WIN!  ");
		System.out.println("                              ");
		System.out.println("==============================");
		System.out.println("");
	}
	//게임 오버 시 출력 메소드
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
				Player.maximumstat = 50; //스탯 포인트 초기화
				PrintMethods.ClearScreen();
				MainPage.main(null); //다시 시작
				break;
			} else if(selectYN.equals("N") || selectYN.equals("n")) {
				System.out.println("");
				System.out.println("===================================");
				System.out.println("    Exit Game. Try Again Later!  ");
				System.out.println("===================================");
				System.exit(0);
			} else if(selectYN.equals("")) {
				System.out.println("▶ Please Enter right command!");
				System.out.println("");
			} else {
				System.out.println("▶ Please Enter right command!");
				System.out.println("");
			}
		}
	}
}
