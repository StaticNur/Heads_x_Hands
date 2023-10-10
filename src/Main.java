import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("На сколько я понял: Когда начали игру рандомно выбирается защита и атака(в течении игры они константы). Игрок может исцелить себя 4 раза, а монстр нет.\nПосле каждой атаки игрока монстр тоже атакует в ответ. Урон который должен вычитаться из здоровья защищающегося это количество успеха умноженная на атаку\n(напомню защита и атака константы в течении игры).");
        Gamer nik = new Gamer();
        Monster dragon = new Monster();
        boolean flag = true;
        Scanner s = new Scanner(System.in);
        int uron_gemer = 0, uron_dragon = 0;
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Игрок:");
        System.out.println("Здоровье игрока равно: " + nik.getHealth());
        System.out.println("Защита игрока равна: " + nik.getDefense());
        System.out.println("Атака равна " + nik.getAttack());
        System.out.println("Урон нанесенный игроком равна: " + uron_gemer);
        System.out.println("Количество исцелении осталось:  3\n");
        System.out.println("\nМонстр:");
        System.out.println("Здоровье монстра равно: " + dragon.getHealth());
        System.out.println("Защита монстра равна: " + dragon.getDefense());
        System.out.println("Атака равна " + dragon.getAttack());
        System.out.println("Урон нанесенный монстром равна: " + uron_dragon);
        System.out.println("------------------------------------------------------------------------------");
        do {
            System.out.println("Атаковать монстра?\nДа - 1\nНет - 2");
            int attack = s.nextInt();
            switch (attack) {
                case 1:
                    uron_gemer = nik.Attack(dragon.getDefense());
                    if (dragon.getHealth() > 0) {
                        dragon.setHealth(dragon.getHealth() - uron_gemer); //наносим урон
                    }
                    uron_dragon = dragon.Attack(nik.getDefense());
                    if (nik.getHealth() > 0) {
                        nik.setHealth(nik.getHealth() - uron_dragon); //наносим урон
                    }
                    break;
                case 2:
                    uron_dragon = dragon.Attack(nik.getDefense());
                    if (nik.getHealth() > 0) {
                        nik.setHealth(nik.getHealth() - uron_dragon); //наносим урон
                    } else {
                        flag = false;
                    }
                    if (dragon.getHealth() > 0) {
                        flag = true;
                    }
                    break;
            }
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("Игрок:");
            System.out.println("Здоровье игрока равно: " + nik.getHealth());
            System.out.println("Защита игрока равна: " + nik.getDefense());
            System.out.println("Атака равна " + nik.getAttack());
            if (uron_gemer == 100) {
                System.out.println("Урон нанесенный игроком равна: мимо!!!");
            } else {//в случаи промоха или нажатии НЕТ
                System.out.println("Урон нанесенный игроком равна: " + uron_gemer);
            }
            System.out.println("Количество исцелении осталось:  " + (3 - nik.getTry_heal()));
            System.out.println("\nМонстр:");
            System.out.println("Здоровье монстра равно: " + dragon.getHealth());
            System.out.println("Защита монстра равна: " + dragon.getDefense());
            System.out.println("Атака равна " + dragon.getAttack());
            if (uron_dragon == 100) {
                System.out.println("Урон игрока равна: мимо!!!");
            } else {
                System.out.println("Урон нанесенный монстром равна: " + uron_dragon);
            }
            System.out.println("-------------------------------------------------------------------------------");
            if (nik.getTry_heal() < 3) {
                System.out.println("Исцелить игрока?\tДа - 1\tНет - 2");
                flag = true;
                do {
                    int iscelit = s.nextInt();
                    if (iscelit == 1) {
                        nik.heal();
                        flag = false;
                    } else if (iscelit != 2) {
                        System.out.println("Вы не выбрали!!!");
                    } else {
                        flag = false;
                        break;
                    }
                } while (flag);
            }
            flag = true;
            if ((nik.getHealth() <= 0) && (dragon.getHealth() <= 0)) {
                System.out.println("Здоровье игрока равно: " + nik.getHealth());
                System.out.println("Здоровье монстра равно: " + dragon.getHealth());
                System.out.println("\nИгрок умер. Ничьия!!!");
                flag = false;
            } else if (nik.getHealth() <= 0) {
                System.out.println("Здоровье игрока равно: " + nik.getHealth());
                System.out.println("\nИгрок умер. Вы проиграли!!!");
                flag = false;
            } else if (dragon.getHealth() <= 0) {
                System.out.println("Здоровье монстра равно: " + dragon.getHealth());
                System.out.println("\nМонстр умер. Вы выиграли!!!");
                flag = false;
            }
        } while (flag);
    }
}