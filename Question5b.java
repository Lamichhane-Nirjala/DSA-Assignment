import java.util.*;

class WeatherThread extends Thread{

    String city;

    WeatherThread(String city){
        this.city=city;
    }

    public void run(){

        try{

            System.out.println("Fetching weather for "+city);

            Thread.sleep(1000); // simulate API delay

            System.out.println(city+" weather data received");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

public class Question5B {

    public static void main(String[] args) {

        String[] cities={
                "Kathmandu",
                "Pokhara",
                "Biratnagar",
                "Nepalgunj",
                "Dhangadhi"
        };

        long start=System.currentTimeMillis();

        ArrayList<WeatherThread> threads=new ArrayList<>();

        for(String city:cities){

            WeatherThread t=new WeatherThread(city);
            threads.add(t);
            t.start();
        }

        for(WeatherThread t:threads){

            try{
                t.join();
            }catch(Exception e){}
        }

        long end=System.currentTimeMillis();

        System.out.println("Total Time: "+(end-start)+" ms");
    }
}