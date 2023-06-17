package ru.netology.smarthouse;

public class Radio {
    private int currentStation;      // номер текущей радиостанции
    private int currentVolume;              // текущая громкость

    public int getCurrentStation() {        //возвращаем значение станции
        return currentStation;
    }

    public void setCurrentStation(int newCurrentStation) {  //получаем значение станции
        if (newCurrentStation < 0) {
            return;
        }
        if (newCurrentStation > 9) {
            return;
        }
        currentStation = newCurrentStation;
    }

    public int getVolume() {                 //возвращаем значение громкости
        return currentVolume;
    }

    public void setVolume(int newVolume) {           //получаем значение громкости
        if (newVolume > 10) {
            return;
        }
        if (newVolume < 0) {
            return;
        }
        currentVolume = newVolume;
    }

    // КАНАЛЫ


    public void next() {                    //переключение станции на +1
        if (currentStation > 8) {
            currentStation = 0;
        } else currentStation++;
    }

    public void prev() {                     //переключение станции на -1
        if (currentStation < 1) {
            currentStation = 9;
        } else currentStation--;
    }

    //ГРОМКОСТЬ

    public void volumeUp() {            //устанавливаем максимальную громкость 10
        if (currentVolume < 10) {
            currentVolume++;
        }
        if (currentVolume >= 10) {
            currentVolume = 10;
        }
    }

    public void volumeDown() {            //устанавливаем минимальную громкость 0
        if (currentVolume > 0) {
            currentVolume--;
        }
        if (currentVolume <= 0) {
            currentVolume = 0;
        }
    }
}
