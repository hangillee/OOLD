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
		
		int selectMenu = 0; //���� ȭ�� �������� ����
		char selectYN; //���� ���� Ȯ�� �������� ����
		
		System.out.println("");
		System.out.println("1. ���� ����"); //������ ���
		System.out.println("2. ���� ����");
		System.out.print("���� : ");
		selectMenu = scan.nextInt();
		System.out.println("");
		
		while (true) { //���� �޴� ������
			if(selectMenu == 1) {
				storyStage.Prologue();
				break;
			} else if(selectMenu == 2) {
				System.out.print("���� ������ �����Ͻðڽ��ϱ�?(Y or N): ");
				selectYN = scan.next().charAt(0);
				if(selectYN == 'Y' || selectYN == 'y') {
					System.exit(0);
				} else if(selectYN == 'N' || selectYN == 'n') {
					PrintMainPage();
					break;
				} else {
					System.out.println("�߸��� �����Դϴ�. �ٽ� �Է����ּ���.");
					System.out.println("");
				}
			} else {
				System.out.println("�߸��� �޴��� �����ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				System.out.println("");
			}
		}
	}
}
