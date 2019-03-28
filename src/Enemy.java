
public class Enemy extends Character{
	private Enemy(int health, int attack, int defend, int dexterity, String name){
		this.setHealth(health);
		this.setAttack(attack);
		this.setDefend(defend);
		this.setDexterity(dexterity);
		this.setName(name);
	}
	public static class EnemyCreator{
		private int health = 0;
		private int attack = 0;
		private int defend = 0;
		private int dexterity = 0;
		private String name = null;
		
		public EnemyCreator(){
			
		}
		public EnemyCreator setHealth(int health) {
			this.health = health;
			return this;
		}
		public EnemyCreator setAttack(int attack) {
			this.attack = attack;
			return this;
		}
		public EnemyCreator setDefend(int defend) {
			this.defend = defend;
			return this;
		}
		public EnemyCreator setDexterity(int dexterity) {
			this.dexterity = dexterity;
			return this;
		}
		public EnemyCreator setName(String name) {
			this.name = name;
			return this;
		}
		public Enemy Create() {
			return new Enemy(health, attack, defend, dexterity, name);
		}
	}
}
