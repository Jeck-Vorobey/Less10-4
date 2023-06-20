package ru.netology.smarthouse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {
    //Radio station = new Radio();

    @Test
    public void getCurrentPozition() {              // проверка значений по умолчанию
        Radio currents = new Radio();

        Assertions.assertEquals(9, currents.getMaxStation());
        Assertions.assertEquals(0, currents.getMinStation());
        Assertions.assertEquals(0, currents.getCurrentStation());
        Assertions.assertEquals(100, currents.getMaxVolume());
        Assertions.assertEquals(0, currents.getMinVolume());
        Assertions.assertEquals(0, currents.getCurrentVolume());
        Assertions.assertEquals(101, currents.getCurrentSize());
    }


    //СТАНЦИИ

    // ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void shouldNoSetBigNumber() { //проверяем, может ли радио выставить НЕдопустимый номер станции больше 9
        Radio station = new Radio();

        station.setCurrentStation(10);

        int expected = 0;

        Assertions.assertEquals(expected, station.getCurrentStation());
    }

    @Test
    public void shouldNoSetLessNumber() { //проверяем, может ли радио выставить НЕдопустимый номер станции меньше 0
        Radio station = new Radio();

        station.setCurrentStation(-1);

        int expected = 0;

        Assertions.assertEquals(expected, station.getCurrentStation());
    }

    @Test
    public void shouldSetNullNumber() { //проверяем, может ли радио выставить граничное нулевое значение канала
        Radio station = new Radio();

        station.setCurrentStation(0);

        int expected = 0;

        Assertions.assertEquals(expected, station.getCurrentStation());
    }

    @Test
    public void shouldSetMaxNumber() { //проверяем, может ли радио выставить граничное максимальное значение канала
        Radio station = new Radio();

        station.setCurrentStation(9);

        int expected = 9;

        Assertions.assertEquals(expected, station.getCurrentStation());
    }


    //ФУНКЦИОНАЛЬНОСТЬ ПО СТАНЦИЯМ
    @Test
    public void shouldSetNextStation() {        //должен устанавливать следующую станцию
        Radio station = new Radio();

        station.setCurrentStation(5);
        station.next();

        int expected = 6;

        Assertions.assertEquals(expected, station.getCurrentStation());
    }

    @Test
    public void shouldSetNextStation0() {        //должен устанавливать следующую станцию, если больше 9, то 0
        Radio station = new Radio();

        station.setCurrentStation(9);
        station.next();

        int expected = 0;

        Assertions.assertEquals(expected, station.getCurrentStation());
    }

    @Test
    public void shouldSetPrevStation() {        //должен устанавливать следующую станцию вниз
        Radio station = new Radio();

        station.setCurrentStation(1);
        station.prev();

        int expected = 0;

        Assertions.assertEquals(expected, station.getCurrentStation());
    }

    @Test
    public void shouldSetPrevStation0() {        //должен устанавливать 9 станцию, если текущая = 0
        Radio station = new Radio();

        station.setCurrentStation(0);
        station.prev();

        int expected = 9;

        Assertions.assertEquals(expected, station.getCurrentStation());
    }


    //ГРОМКОСТЬ

    @Test
    public void shouldSetMinVolume() {          //проверка установления минимальной громкости

        Radio station = new Radio();

        station.setVolume(0);

        int expected = 0;

        Assertions.assertEquals(expected, station.getMinVolume());
    }

    @Test
    public void shouldSetMaxVolume() {          //проверка установления максимальной громкости
        Radio station = new Radio();

        station.setVolume(100);

        int expected = 100;

        Assertions.assertEquals(expected, station.getMaxVolume());
    }

    @Test
    public void shouldSetMediumVolume() {          //проверка установления серединного значения громкости
        Radio station = new Radio();

        station.setVolume(5);

        int expected = 5;

        Assertions.assertEquals(expected, station.getCurrentVolume());
    }

    @Test
    public void shouldNoSetMinVolume() {          //проверка на НЕдопустимое значение громкости менее 0
        Radio station = new Radio();

        station.setVolume(-1);

        int expected = 0;

        Assertions.assertEquals(expected, station.getCurrentVolume());
    }

    @Test
    public void shouldNoSetBigVolume() {            //проверка на НЕдопустимое значение громкости более 100
        Radio station = new Radio();

        station.setVolume(101);

        int expected = 0;

        Assertions.assertEquals(expected, station.getCurrentVolume());
    }

//ФУНКЦИОНАЛЬНОСТЬ ПО ГРОМКОСТИ

    @Test
    public void shouldSetMaxLimitVolume() {         //проверка при переключении +1 на НЕдопустимое значение громкости более 100
        Radio station = new Radio();

        station.setVolume(100);
        station.volumeUp();

        int expected = 100;

        Assertions.assertEquals(expected, station.getCurrentVolume());
    }


    @Test
    public void shouldSetNextVolume() {         //должен изменять значение громкости на +1
        Radio station = new Radio();

        station.setVolume(9);
        station.volumeUp();

        int expected = 10;


        Assertions.assertEquals(expected, station.getCurrentVolume());
    }

    @Test
    public void shouldSetNextMinVolume() {         //должен изменять значение громкости с 0 на 1
        Radio station = new Radio();

        station.setVolume(0);
        station.volumeUp();

        int expected = 1;

        Assertions.assertEquals(expected, station.getCurrentVolume());
    }

    @Test
    public void shouldSetDownVolume() {     //должен изменять значение громкости на -1
        Radio station = new Radio();

        station.setVolume(1);
        station.volumeDown();

        int expected = 0;

        Assertions.assertEquals(expected, station.getCurrentVolume());
    }

    @Test
    public void shouldSetMinDownVolume() {     //должен устанавливать значение громкости не менее 0
        Radio station = new Radio();

        station.setVolume(0);
        station.volumeDown();

        int expected = 0;

        Assertions.assertEquals(expected, station.getCurrentVolume());
    }

    @Test
    public void shouldSetMaxUpVolume() {     //должен устанавливать значение громкости на -1 из максимального значения
        Radio station = new Radio();

        station.setVolume(100);
        station.volumeDown();

        int expected = 99;

        Assertions.assertEquals(expected, station.getCurrentVolume());
    }

    @Test
    public void shouldSetStationNumber() {          // проверяем принятие граничных значений станции
        Radio station = new Radio(1, 200);

        Assertions.assertEquals(1, station.getMinStation());
        Assertions.assertEquals(200, station.getMaxStation());
        Assertions.assertEquals(1, station.getCurrentStation());
        Assertions.assertEquals(199, station.getCurrentSize());
    }

    @Test
    public void shouldSetQuantityStation() {       //может ли радио выставить заданное количество каналов (20)
        Radio station = new Radio(20);

        Assertions.assertEquals(20, station.getCurrentSize());
        Assertions.assertEquals(0, station.getMinStation());
        Assertions.assertEquals(20, station.getMaxStation());
        Assertions.assertEquals(0, station.getMinStation());
    }

    @Test
    public void testConstructorSizeZero() {       //может ли радио выставить 0 количество каналов
        Radio station = new Radio(0);

        Assertions.assertEquals(101, station.getCurrentSize());
    }


}


