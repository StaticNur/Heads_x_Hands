public class Gamer implements Options{
    private int attack = 1 + (int) ( Math.random() * 20); //Атака;
    private int defense = 1 + (int) ( Math.random() * 20);//Защита от 1 до 20
    private int health = 50;//Здоровье захотел взять 50
    private int damage = 0; //сумма значении кубиков
    public void setHealth(int health) {
        this.health = health;
    }
    public int getAttack() {return attack;}
    public int getHealth() {
        return health;
    }
    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense){
        this.defense = defense;
    }

    public int getTry_heal() {
        return try_heal;
    }
    private int try_heal = 0;
    public void heal(){  //исцеление
        try_heal++;
        setHealth(getHealth() + getHealth()/2);
    }
    public int  Attack(int defense_dragon) {
        //attack = 1 + (int) ( Math.random() * 20); //урон
        int sum_uron = 0;
        damage = attack - defense_dragon + 1;  //модификатор атаки
        if(damage<=0){
            damage = 1;
        }
        for(int i = 0; i < damage; i++){    //количество кубиков
            int a = 1 + (int)( Math.random() * 6);
            if((a == 5)||(a == 6)){ //успех
                sum_uron++;
            }
        }
        if(sum_uron==0){
            System.out.println("\nКоличество успешных атак игрока "+sum_uron);
            return 100;
        }
        System.out.println("\nКоличество успешных атак игрока "+sum_uron);
        return attack*sum_uron;
    }
}
