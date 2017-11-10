package albumdatabase;
import java.text.DecimalFormat;

public class Duration 
{
    private int hours;
    private int minutes;
    private int seconds;

        public static void main(String[] args) 
    {
        Duration d1 = new Duration(1,10,10);
        System.out.println(d1);
        Duration meme = new Duration(1,30,30);
        System.out.println(meme);
        d1.add(meme);
        System.out.print(d1);
        
    }

    //Constructor that takes integer parameters to build Duration with.
    public Duration(int hours, int minutes, int seconds) 
    { 
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    //Default Constructor for Duration
    public Duration() 
    { 
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }
    
        //Constuctor that accepts String input and parses as Integer
        public Duration(String duration)
        {
        String[] time = duration.split(":");
        String stringHours = time[0];
        String stringMinutes = time[1];
        String stringSeconds = time[2];
        hours = Integer.parseInt(stringHours);
        minutes = Integer.parseInt(stringMinutes);
        seconds = Integer.parseInt(stringSeconds);   
        }
        
        //toString method that converts a Duration object into a String object
        public String toString()
        {
        DecimalFormat df = new DecimalFormat("00");
        String stringHours = df.format(this.hours);
        String stringMinutes = df.format(this.minutes);
        String stringSeconds = df.format(this.seconds);
        return stringHours + ":" + stringMinutes + ":" + stringSeconds;
        } 
        
        //Add method that accepts another Duration object as a parameter to add to the original object
        public void add(Duration d2)
        {
            if(seconds + d2.seconds >= 60)
            {
                minutes += ((seconds + d2.seconds) / 60); //Finds out the amount of extra minutes and adds that result to the minutes variable
                seconds = ((seconds + d2.seconds) % 60); //Finds out the remainder to set the new seconds
                System.out.println("New Minutes: " + minutes);
                System.out.println("New Seconds: " + seconds);
            }else{
                seconds += d2.seconds;
            }
            
            if(minutes + d2.minutes >= 60)
            {
                hours += ((minutes + d2.minutes) / 60); //Finds out the amount of extra hours and adds that result to the hours variable
                minutes = ((minutes + d2.minutes) % 60); //Finds out the remainder to set the new minutes
                System.out.println("New Hours: "+ hours);
                System.out.println("New Minutes: " + minutes);
            }else{
                minutes += d2.minutes;
            }
            hours += d2.hours;
            
        }
    
//Getter methods for each variable    
    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
     
}
