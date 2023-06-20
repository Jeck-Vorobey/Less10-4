package ru.netology.smarthouse;

public class Radio {

    // ИСХОДНЫЕ ДАННЫЕ
    private int maxStation = 9;                       //максимальный канал по умолчанию *
    private int minStation = 0;                       // минимальный канал по умолчанию *
    private int currentStation = minStation;          // номер текущего канала *
    private int size = 101;                           //количество каналов по умолчанию

    private int maxVolume = 100;                       //максимальная громкость по умолчанию *
    private int minVolume = 0;                         // минимальная громкость по умолчанию *
    private int currentVolume = minVolume;             //текущая громкость по умолчанию = минимальной *

    public Radio(int minStation, int maxStation) {     //конструктор для изменения исходных данных для каналов *
        //if (minStation < maxStation) {
        this.minStation = minStation;
        this.maxStation = maxStation;
        this.currentStation = minStation;
        this.size = maxStation - minStation;
        //} else return;
    }

    public Radio(int size) {                              // конструктор для изменения количества каналов *
        if (size > 0) {
            this.size = size;
            this.maxStation = minStation + size;        // здесь minStation = 1
        } else return;
    }

    public Radio() {
    }                                     // пустой конструктор *


    public int getCurrentStation() {        // получаем значение текущего канала *
        return currentStation;
    }

    public int getMaxStation() {            // получаем значение максимального канала *
        return maxStation;
    }

    public int getMinStation() {            // получаем значение минимального канала *
        return minStation;
    }

    public int getCurrentSize() {           // получаем значение текущего количества каналов *
        return size;
    }

    public void setCurrentStation(int newCurrentStation) {  // объявляем граничные значения текущего канала *
        if (newCurrentStation < minStation) {                        // *
            return;
        }
        if (newCurrentStation > maxStation) {                // *
            return;
        }
        currentStation = newCurrentStation;
    }

    public int getCurrentVolume() {                          // получаем значение текущей громкости
        return currentVolume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public int getMinVolume() {
        return minVolume;
    }


    public void setVolume(int newVolume) {           // объявляем значение громкости
        if (newVolume > maxVolume) {
            return;
        }
        if (newVolume < minVolume) {
            return;
        }
        currentVolume = newVolume;
    }

    // КАНАЛЫ


    public void next() {                              //переключение канала на +1
        if (currentStation < maxStation) {
            currentStation++;
        } else currentStation = 0;
    }

    public void prev() {                              //переключение канала на -1
        if (currentStation > minStation) {
            currentStation--;
        } else currentStation = maxStation;
    }

    //ГРОМКОСТЬ

    public void volumeUp() {                          // переключаем громость +1 до максимума и останавливаемся
        if (currentVolume < maxVolume) {
            currentVolume++;
        } else currentVolume = maxVolume;
    }

    public void volumeDown() {                       // переключаем громость -1 до минимума и останавливаемся
        if (currentVolume > minVolume) {
            currentVolume--;
        } else currentVolume = minVolume;
    }
}
