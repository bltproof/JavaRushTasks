package com.javarush.task.task25.task2515;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Главный класс игры - Космос (Space)
 */
public class Space {
    //Ширина и высота игрового поля
    private int width;
    private int height;

    //Космический корабль
    private SpaceShip ship;
    //Список НЛО
    private List<Ufo> ufos = new ArrayList<>();
    //Список бомб
    private List<Bomb> bombs = new ArrayList<>();
    //Список ракет
    private List<Rocket> rockets = new ArrayList<>();

    private int count = 0;

    public Space(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Основной цикл программы.
     * Тут происходят все важные действия
     */
    public void run() {
        //Создаем холст для отрисовки.
        Canvas canvas = new Canvas(width, height);

        //Создаем объект "наблюдатель за клавиатурой" и стартуем его.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        //Игра работает, пока корабль жив
        while (ship.isAlive()) {
            //"наблюдатель" содержит события о нажатии клавиш?
            if (keyboardObserver.hasKeyEvents()) {
                KeyEvent event = keyboardObserver.getEventFromTop();
                //Если "стрелка влево" - сдвинуть фигурку влево
                System.out.print(event.getKeyCode());
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    ship.moveLeft();
                    //Если "стрелка вправо" - сдвинуть фигурку вправо
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    ship.moveRight();
                    //Если "пробел" - стреляем
                else if (event.getKeyCode() == KeyEvent.VK_SPACE)
                    ship.fire();
            }

            //двигаем все объекты игры
            moveAllItems();

            //проверяем столкновения
            checkBombs();
            checkRockets();
            //удаляем умершие объекты из списков
            removeDead();

            //Создаем НЛО (1 раз в 10 ходов)
            createUfo();

            //Отрисовываем все объекты на холст, а холст выводим на экран
            canvas.clear();
            draw(canvas);
            canvas.print();

            //Пауза 300 миллисекунд
            Space.sleep(300);
        }

        //Выводим сообщение "Game Over"
        System.out.println("Game Over!");
    }

    /**
     * Двигаем все объекты игры
     */
    public void moveAllItems() {
        //нужно получить список всех игрвых объектов и у каждого вызвать метод move().
        for (BaseObject object : getAllItems()) {
            object.move();
        }
    }

    /**
     * Метод возвращает общий список, который содержит все объекты игры
     */
    public List<BaseObject> getAllItems() {
        //нужно создать новый список и положить в него все игровые объекты.
        List<BaseObject> list = new ArrayList<>();

        list.addAll(bombs);
        list.addAll(rockets);
        list.addAll(ufos);
        list.add(ship);

        return list;
    }

    /**
     * Создаем новый НЛО. 1 раз на 10 вызовов.
     */
    public void createUfo() {
        //тут нужно создать новый НЛО.
        //1 раз за 10 вызовов метода.
        count++;
        if (count == 10) {
            ufos.add(new Ufo(Math.random() * width, Math.random() * height / 2));
        }
    }

    /**
     * Проверяем бомбы.
     * а) столкновение с кораблем (бомба и корабль умирают)
     * б) падение ниже края игрового поля (бомба умирает)
     */
    public void checkBombs() {
        //тут нужно проверить все возможные столкновения для каждой бомбы.
        for (Bomb bomb : bombs) {
            if (ship.isIntersect(bomb)) {
                ship.die();
                bomb.die();
            }

            if (bomb.getY() >= height)
                bomb.die();
        }
    }

    /**
     * Проверяем рокеты.
     * а) столкновение с НЛО (ракета и НЛО умирают)
     * б) вылет выше края игрового поля (ракета умирает)
     */
    public void checkRockets() {
        //тут нужно проверить все возможные столкновения для каждой ракеты.
        for (Rocket rocket : rockets) {
            for (Ufo ufo : ufos) {
                if (ufo.isIntersect(rocket)) {
                    ufo.die();
                    rocket.die();
                }
            }

            if (rocket.getY() <= height)
                rocket.die();
        }
    }

    /**
     * Удаляем умершие объекты (бомбы, ракеты, НЛО) из списков
     */
    public void removeDead() {
        //тут нужно удалить все умершие объекты из списков.
        //Кроме космического корабля - по нему определяем идет еще игра или нет.
        for (Bomb bomb : new ArrayList<>(bombs)) {
            if (!bomb.isAlive()) bombs.remove(bomb);
        }
        for (Rocket rocket : new ArrayList<>(rockets)) {
            if (!rocket.isAlive()) rockets.remove(rocket);
        }
        for (Ufo ufo : new ArrayList<>(ufos)) {
            if (!ufo.isAlive()) ufos.remove(ufo);
        }
    }

    /**
     * Отрисовка всех объектов игры:
     * а) заполняем весь холст точками.
     * б) отрисовываем все объекты на холст.
     */
    public void draw(Canvas canvas) {
        //тут нужно отрисовать все объекты игры
    }


    public SpaceShip getShip() {
        return ship;
    }

    public void setShip(SpaceShip ship) {
        this.ship = ship;
    }

    public List<Ufo> getUfos() {
        return ufos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Bomb> getBombs() {
        return bombs;
    }

    public List<Rocket> getRockets() {
        return rockets;
    }

    public static Space game;

    public static void main(String[] args) throws Exception {
        game = new Space(20, 20);
        game.setShip(new SpaceShip(10, 18));
        game.run();
    }

    /**
     * Метод делает паузу длинной delay миллисекунд.
     */
    public static void sleep(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
        }
    }
}