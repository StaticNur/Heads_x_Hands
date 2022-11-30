public class Monster implements Options {
    private int attack = 1 + (int) ( Math.random() * 20);; //атака
    private int defense = 1 + (int) ( Math.random() * 20);//защита
    private int health = 50;
    private int damage = 0; //сумма значении кубиков от 1 до 6
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
    int try_heal= 0;
    public void heal(){  //исцеление
        if(try_heal < 3){
            try_heal++;
            setHealth(getHealth() + getHealth()/2);
        }else {
            System.out.println("Нельзя исцельять себя более 3-х раз!");
        }
    }
    @Override
    public int  Attack(int defense_gemer) {
        //attack = 1 + (int) ( Math.random() * 20);
        int sum_uron = 0;
        damage = attack - defense_gemer + 1;  //модификатор атаки
        if (damage<=0){
            damage=1;
        }
        for(int i = 0; i < damage; i++){
            int a = 1 + (int)( Math.random() * 6);
            if((a == 5)||(a == 6)){
                sum_uron++;
            }
        }
        if(sum_uron==0){
            System.out.println("\nКоличество успешных атак монстра "+sum_uron);
            return 100;
        }
        System.out.println("\nКоличество успешных атак монстра "+sum_uron);

        return attack*sum_uron;

    }
}
