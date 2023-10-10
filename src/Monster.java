public class Monster implements Creatures {
    private int attack = 1 + (int) (Math.random() * 30);
    ; //атака
    private int defense = 1 + (int) (Math.random() * 30);//защита
    private int health = 50;
    private int damage = 0; //сумма значении кубиков от 1 до 6

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }

    public int getDefense() {
        return defense;
    }

    @Override
    public int Attack(int defense_gemer) {
        int sum_uron = 0;
        damage = attack - defense_gemer + 1;  //модификатор атаки
        if (damage <= 0) {
            damage = 1;
        }
        for (int i = 0; i < damage; i++) {
            int a = 1 + (int) (Math.random() * 6);
            if ((a == 5) || (a == 6)) {
                sum_uron++;
            }
        }
        if (sum_uron == 0) {
            System.out.println("\nКоличество успешных атак монстра " + sum_uron);
            return 100;
        }
        System.out.println("\nКоличество успешных атак монстра " + sum_uron);
        return attack * sum_uron;

    }
}
