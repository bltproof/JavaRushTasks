package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {

        Beach firstBeach = new Beach("Miami", 2.5f, 2);
        Beach secondBeach = new Beach("Malibu", 1.5f, 4);

        System.out.println(firstBeach.compareTo(secondBeach));

    }

    @Override
    public synchronized int compareTo(Beach o) {
        int distanceParam = (int) (this.distance - o.getDistance());
        int qualityParam = this.quality - o.getQuality();
        return this.name.compareTo(o.getName());
    }
}
