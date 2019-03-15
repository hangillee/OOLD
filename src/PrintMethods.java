import java.util.Scanner;

public class PrintMethods {
	public static void clearScreen() {
	    for (int i = 0; i < 80; i++) {
	      System.out.println("");
	    }
	}
	
	public static void PrintIntro() {
		System.out.println("========================================");
		System.out.println("=                                      =");
		System.out.println("=   Only One Life Dungeon              =");
		System.out.println("=                                      =");
		System.out.println("=                   Made by Basileus   =");
		System.out.println("=                                      =");
		System.out.println("========================================");
	}
	
	public void PrintMainPage() {
		Scanner scan = new Scanner(System.in);
		StoryStage storyStage = new StoryStage();
		
		int selectMenu = 0; //메인 화면 선택지용 변수
		char selectYN; //게임 종료 확인 선택지용 변수
		
		System.out.println("");
		System.out.println("1. 게임 시작"); //선택지 출력
		System.out.println("2. 게임 종료");
		System.out.print("선택 : ");
		selectMenu = scan.nextInt();
		System.out.println("");
		
		while (true) { //메인 메뉴 선택지
			if(selectMenu == 1) {
				storyStage.Prologue();
				break;
			} else if(selectMenu == 2) {
				System.out.print("정말 게임을 종료하시겠습니까?(Y or N): ");
				selectYN = scan.next().charAt(0);
				if(selectYN == 'Y' || selectYN == 'y') {
					System.exit(0);
				} else if(selectYN == 'N' || selectYN == 'n') {
					PrintMainPage();
					break;
				} else {
					System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
					System.out.println("");
				}
			} else {
				System.out.println("잘못된 메뉴를 선택하셨습니다. 다시 입력해주세요.");
				System.out.println("");
			}
		}
	}
}
