package org.kievdemo;


import java.util.Date;

/**
 * Created by Ann on 18.05.2015.
 */
public class OutDoor extends Event {
    private String dress;

    public OutDoor(String eventName, Place namePlace) {
        super();
        //throws MyExeption куда его?
        //доделай этот конструктор, кидани для него исключение в виде 18 сонета Шекспира. Радуйся жизни и спи КАЖДЫЙ день.
        //или ввод числа всместо строки и наоборот
    }

    public OutDoor(String name, Place place, double cost, String descrption, Date time, String tag, String dress) {
        super(name, place, cost, descrption, time, tag);
        this.dress = dress;
    }
//public void getInfo(){
//    System.out.print();
//}
    @Override
    public void getInfo() {

    }

    public String getDress() {
        return dress;
    }

    public void setDress(String dress) {
        this.dress = dress;
    }
    /*
            А почему оно зеленое? И неужели теперь придется создавать еще и классы а-ля "Галерея", "Экскурсия" и т.д.?
            Но вот Occurrence мне тут совсем не нужен. И куда его отправить? Просто "пустая реализация"?
            И почему во всех примерах сплошь и рядом фигурирует некое загадочное е?
            */
    @Override
    public Occurrence getOccurrence() {
        return null;
    }
}
