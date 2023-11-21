import java.util.Date;
import java.util.logging.Level;

public  class Activity implements Comparable<Activity>  {
    public
    String Activity_name;
    String Person_name;
    double duration;
    Date date;
    double distance;
    double avg_heart_rate;
    double intensity;

    level l;

    enum level{
        very_light,
        light,
        moderate,
        vigorous,
        very_vigorous;

        // for swimming
        static level en;
        public static void getDATA_enum(Activity a){
             ;
                if(a.Activity_name.equalsIgnoreCase("swimming")==true && a.intensity<=0.5){
                    a.setLevel(light);
                }
                else if(a.Activity_name.equalsIgnoreCase("swimming")==true && a.intensity<=1.25 &&a.intensity>0.5){
                     a.setLevel(very_light);
                }
                else if(a.Activity_name.equalsIgnoreCase("swimming")==true && a.intensity<=2 && a.intensity>1.25){
                    a.setLevel(moderate);
                }
                else if(a.Activity_name.equalsIgnoreCase("swimming")==true && a.intensity>2 && a.intensity<2.75){
                    a.setLevel(very_vigorous);
                }
                else if(a.Activity_name.equalsIgnoreCase("swimming")==true ){
                     a.setLevel(vigorous);
                }
                //for running
                else if(a.Activity_name.equalsIgnoreCase("running")==true && a.intensity<=4){
                     a.setLevel(very_light);
                }
                else if(a.Activity_name.equalsIgnoreCase("running")==true && a.intensity>4 && a.intensity<=8){
                    a.setLevel(light);
                }
                else if(a.Activity_name.equalsIgnoreCase("running")==true && a.intensity>8 && a.intensity<=12){
                     a.setLevel(moderate);
                }
                else if(a.Activity_name.equalsIgnoreCase("running")==true && a.intensity>12 && a.intensity<=18){
                     a.setLevel(vigorous);
                }
                else if(a.Activity_name.equalsIgnoreCase("running")==true && a.intensity>18 && a.intensity<=24){
                     a.setLevel(very_vigorous);
                }
                //cycling
                else if(a.Activity_name.equalsIgnoreCase("cycling")==true &&a.intensity<=8){
                    a.setLevel(very_light);
                }
                else if(a.Activity_name.equalsIgnoreCase("cycling")==true &&a.intensity>8 && a.intensity<=16){
                    a.setLevel(light);
                }
                else if(a.Activity_name.equalsIgnoreCase("cycling")==true &&a.intensity>16 && a.intensity<=25){
                     a.setLevel(moderate);
                }
                else if(a.Activity_name.equalsIgnoreCase("cycling")==true &&a.intensity>25 && a.intensity<=33){
                     a.setLevel(vigorous);
                }
                else if(a.Activity_name.equalsIgnoreCase("cycling")==true &&a.intensity>33 && a.intensity<=40) {
                     a.setLevel(very_vigorous);
                }
        }
    }


    /**
     *Para_constructor
     * @param

     */
    public Activity(String n, String an, Date date, double d, double dis, double avr, double intensity){
        this.Person_name=n;
        this.Activity_name=an;
        this.date=date;
        this.duration=d;
        this.distance=dis;
        this.avg_heart_rate=avr;
        this.intensity=intensity;
    }

    /**default
     * Constructor
     */
    public Activity(){

    }

    /**
     *GETTER_SETTER
     * @param
     */
    void setLevel(level l){
        this.l=l;
    }
    level getLevel(){
        return this.l;
    }
    void setActivity_name(String an){
        this.Activity_name=an;
    }
    String getActivity_name(){
        return this.Activity_name;
    }
    void setPerson_name(String n){
        this.Person_name=n;
    }
    String getPerson_name(){
        return this.Person_name;
    }
    void setDuration(double d){
        this.duration=d;
    }
    double getDuration(){
        return this.duration;
    }
    void setDate(Date date){
        this.date=date;
    }
    Date getDate(){
        return this.date;
    }
    void setDistance(double dis){
        this.distance=dis;
    }
    double getDistance(){
        return this.distance;
    }
    void setavg_heart_rate(Double avr){
        this.avg_heart_rate=avr;
    }
    double getAvg_heart_rate(){
       return  this.avg_heart_rate;
    }
void setIntensity(double i){
        this.intensity=i;
}
double getIntensity(){
        return this.intensity;
}

    /**
     *
     * @return toString
     */
    public String toString() {
        return "Activity{" +
                "Activity_name='" + Activity_name + '\'' +
                ", Person_name='" + Person_name + '\'' +
                ", duration=" + duration +
                ", date='" + date + '\'' +
                ", distance=" + distance +
                ", avg_heart_rate=" + avg_heart_rate +
                "intensity=" + intensity+
                "calories_burn" + (this.intensity*this.duration)+
                '}';
    }

    /**
     *
      * @param other Comparator
     * @return
     */
    @Override
    public int compareTo(Activity other) {
        if(this.distance<other.distance){
            return -1;
        }
        else if(this.distance>other.distance){
            return 1;
        }
        return 0;

    }

}


