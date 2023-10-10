public class Gamer implements Creatures {
    private int attack = 1 + (int) (Math.random() * 30); //Атака;
    private int defense = 1 + (int) (Math.random() * 30);//Защита от 1 до 30
    private int health = 50;//Здоровье захотел взять 50
    private int damage = 0; //сумма значении кубиков

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

    public int getTry_heal() {
        return try_heal;
    }

    private int try_heal = 0;

    public void heal() {  //исцеление
        if (try_heal < 4) {
            try_heal++;
            setHealth(getHealth() + (int) (getHealth() * 0.3));
        } else {
            System.out.println("Нельзя исцельять себя более 4-х раз!");
        }
    }

    @Override
    public int Attack(int defense_dragon) {
        int sum_uron = 0;
        damage = attack - defense_dragon + 1;  //модификатор атаки
        if (damage <= 0) {
            damage = 1;
        }
        for (int i = 0; i < damage; i++) {    //количество кубиков
            int a = 1 + (int) (Math.random() * 6);
            if ((a == 5) || (a == 6)) { //успех
                sum_uron++;
            }
        }
        if (sum_uron == 0) {
            System.out.println("\nКоличество успешных атак игрока " + sum_uron);
            return 100;
        }
        System.out.println("\nКоличество успешных атак игрока " + sum_uron);
        return attack * sum_uron;
    }
}
