package org.kievdemo;


import java.util.Date;

/**
 * Created by Ann on 18.05.2015.
 */
public class OutDoor extends Event {
    private String dress;

    public OutDoor(String eventName, Place namePlace) {
        super();
        //throws MyExeption ���� ���?
        //������� ���� �����������, ������ ��� ���� ���������� � ���� 18 ������ ��������. ������� ����� � ��� ������ ����.
        //��� ���� ����� ������� ������ � ��������
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
            � ������ ��� �������? � ������� ������ �������� ��������� ��� � ������ �-�� "�������", "���������" � �.�.?
            �� ��� Occurrence ��� ��� ������ �� �����. � ���� ��� ���������? ������ "������ ����������"?
            � ������ �� ���� �������� ������ � ����� ���������� ����� ���������� �?
            */
    @Override
    public Occurrence getOccurrence() {
        return null;
    }
}
