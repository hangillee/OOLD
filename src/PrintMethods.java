import java.util.Scanner;

public class PrintMethods {
	private static final Scanner scan = new Scanner(System.in);
	public static void ClearScreen() { //C의 system("cls"); 기능을 대충 구현, 개선 필요.
	    for (int i = 0; i < 80; i++) {
	      System.out.println("");
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
		insert = scan.nextLine(); //nextInt();의 개행문자 문제 해결을 위한 추가 nextLine();
		
		while(true) { //Enter키를 통해 진행을 위한 조건
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
					System.out.println("▶ Please press right command.");
					System.out.println("");
				}
			} else {
				System.out.println("▶ Please press right command.");
				System.out.println("");
			}
		}
	}
}
