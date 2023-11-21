import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.IOException;

/**
 * Starting of Main function
 */
public class Main {
    static ArrayList<Activity> activities=new ArrayList<>();
    static String filepath="activity.csv";
    public static void main(String[] args) throws IOException, ParseException {
         viewActivites(filepath);
         boolean continuevalue=true;
         while(continuevalue) {

             displaymenu();
             Scanner sc = new Scanner(System.in);


             System.out.print("Enter your choice: ");

             int ch = sc.nextInt();
             if (ch == 1) {
                 displayactivities();

                 System.out.println("choose 1 for ascending data according to dist: ");
                 System.out.println("choose 2 for descending data according to dist: ");
                 System.out.println("choose 3 for ascending data according to duration: ");
                 System.out.println("choose 4 for descending data according to duration: ");
                 System.out.println("choose 5 for ascending data according to date: ");
                 System.out.println("choose 6 for descending data according to date: ");
                 System.out.println("choose 7 for ascending data according to Activity_name: ");
                 System.out.println("choose 8 for descending data according to Activity_name: ");
                 System.out.println("choose 9 for ascending data according to Calories_burn: ");
                 System.out.println("choose 10 for descending data according to calories_burn: ");
                 System.out.println("enter CH1: ");
                 int ch1 = sc.nextInt();
                 if (ch1 == 1) {
                     activities.sort(Comparator.comparingDouble(Activity::getDistance));
                 }
                 if (ch1 == 2) {
                     activities.sort(Comparator.comparingDouble(Activity::getDistance).reversed());
                 }
                 if (ch1 == 3) {
                     activities.sort(Comparator.comparingDouble(Activity::getDuration));
                 }
                 if (ch1 == 4) {
                     activities.sort(Comparator.comparingDouble(Activity::getDuration).reversed());
                 }
                 if (ch1 == 5) {
                     activities.sort(Comparator.comparing((Activity::getDate)));
                 }
                 if (ch1 == 6) {
                     activities.sort(Comparator.comparing(Activity::getDate).reversed());
                 }
                 if (ch1 == 7) {
                     activities.sort(Comparator.comparing(Activity::getActivity_name));
                 }
                 if (ch1 == 8) {
                     activities.sort(Comparator.comparing(Activity::getActivity_name).reversed());
                 }
                 if (ch1 == 9) {
                     activities.sort(Comparator.comparing(Activity -> Activity.getDuration() * Activity.getIntensity()));
                 }
                 if (ch1 == 10) {
                     activities.sort(Comparator.comparing(Activity -> Activity.getDuration() * Activity.getIntensity(), Comparator.reverseOrder()));
                 }
                 displaySortedActivities(activities);
             }
             if (ch == 2) {
                 viewStatistics(activities);
                 System.out.println();
                 System.out.println("GeT statistic by name of a person ");
                 System.out.println("enter the name of person u want to find: ");
                 String name = sc.next();
                 viewStatisticsByName(name);
             }
             if (ch == 3) {
                 ActivityBinarysearch(activities);
             }
             if (ch == 4) {
                 System.out.println("Press 1 to check only swimming activity");
                 System.out.println("Press 2 to check only running activity");
                 System.out.println("Press 3 to check only cycling activity");
                 System.out.println("Press 4 to check by minimum duration");
                 System.out.println("Press 5 to check by minimum distance");
                 System.out.println("Press 6 to get data according to Enum value-light");
                 System.out.println("Press 7 to get data according to Enum value-Verylight");
                 System.out.println("Press 8 to get data according to Enum value-Moderate");
                 System.out.println("Press 9 to get data according to Enum value-Vigorous");
                 System.out.println("Press 10 to get data according to Enum value-Veryvigorous");
                 Scanner scc = new Scanner(System.in);
                 System.out.println("Enter your choice");
                 int chh = scc.nextInt();
                 if (chh == 1) {
                     SwimmingData();
                 }
                 if (chh == 2) {
                     RunningData();
                 }
                 if (chh == 3) {
                     CyclingData();
                 }
                 if (chh == 4) {
                     MinimumDurationData();
                 }
                 if (chh == 5) {
                     MinimumDistanceData();
                 }
                 if (chh == 6) {
                     EnumVeryLightData();
                 }
                 if (chh == 7) {
                     EnumLightData();
                 }
                 if (chh == 8) {
                     EnumModerateData();
                 }
                 if (chh == 9) {
                     EnumvigorousData();
                 }
                 if (chh == 10) {
                     EnumVeryvigorousData();
                 }
             }
             if(ch==5){
                 System.out.println("enter csv file u want to give using .csv notation: ");
                 ActivityUserFile();
             }
             System.out.println("do you want to continue yes or no?");
             String c=sc.next();
             if(c.equalsIgnoreCase("No")){
                 continuevalue=false;
             }
         }
    }

    public static void ActivityUserFile() throws FileNotFoundException, ParseException {
        System.out.println("enter the file path: ");
        Scanner p=new Scanner(System.in);
        String s= p.next();
        filepath=s;
        viewActivites(filepath);
    }

    /**
     * Filterating /subset of data on the basics of Enum value :-
     */
   public static void EnumVeryLightData(){
       for (Activity activity : activities) {
           Activity.level.getDATA_enum(activity);
           if (activity.getLevel().equals(Activity.level.very_light)) {
               System.out.println(activity);
           }
       }
   }
    public static void EnumLightData(){
        for (Activity activity : activities) {
            Activity.level.getDATA_enum(activity);
            if (activity.getLevel().equals(Activity.level.light)) {
                System.out.println(activity);
            }
        }
    }
    public static void EnumModerateData(){
        for (Activity activity : activities) {
            Activity.level.getDATA_enum(activity);
            if (activity.getLevel().equals(Activity.level.moderate)) {
                System.out.println(activity);
            }
        }
    }
    public static void EnumvigorousData(){
        for (Activity activity : activities) {
            Activity.level.getDATA_enum(activity);
            if (activity.getLevel().equals(Activity.level.vigorous)) {
                System.out.println(activity);
            }
        }
    }
    public static void EnumVeryvigorousData(){
        for (Activity activity : activities) {
            Activity.level.getDATA_enum(activity);
            if (activity.getLevel().equals(Activity.level.very_vigorous)) {
                System.out.println(activity);
            }
        }
    }
    /*
    Data according to Swimming,cycling,running
     */
    public static void SwimmingData(){
        for (Activity activity : activities) {
            if (activity.Activity_name.equalsIgnoreCase("Swimming")) {
                System.out.println(activity);
            }
        }
    }
    public static void RunningData(){
        for (Activity activity : activities) {
            if (activity.Activity_name.equalsIgnoreCase("Running")) {
                System.out.println(activity);
            }
        }
    }
    public static void CyclingData(){
        for (Activity activity : activities) {
            if (activity.Activity_name.equalsIgnoreCase("Cycling")) {
                System.out.println(activity);
            }
        }
    }

    /**
     * Printing data according to minimum duration and distance
     */
    public static void MinimumDurationData(){
        activities.sort(Comparator.comparing(Activity::getDuration));
        System.out.println("minimum duration activity data: "+activities.get(0));
    }
    public static void MinimumDistanceData(){
       activities.sort(Comparator.comparing(Activity::getDistance));
        System.out.println("minimum Distance activity data: "+activities.get(0));
    }
    /**
     * display normal menu
     */
    public static void displaymenu() {
         System.out.println("Press 1) Activity display");
         System.out.println("Press 2) Statistics display");
         System.out.println("Press 3) BinarySearchActivity(By Distance)");
         System.out.println("Press 4) view a subset of their activity  ");
        System.out.println("Press 5) User to give csv file ");

    }

    /**
     * display and taking data from csv file
     * FileNotFoundException
     * ParseException
     *
     */
    public static void viewActivites(String filepath) throws FileNotFoundException, ParseException{
      if(filepath.equalsIgnoreCase("activity.csv")) {
          Scanner s = new Scanner(new File(filepath));
          SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
          while (s.hasNext()) {
              String sp = s.next();
              String[] arr = sp.split(",");
              Activity a1 = new Activity(arr[0], arr[1], dateFormat.parse(arr[2]), Double.parseDouble(arr[3]), Double.parseDouble(arr[4]), Double.parseDouble(arr[5]), Double.parseDouble(arr[6]));
              a1.Person_name = arr[0];
              a1.Activity_name = arr[1];
              a1.date = dateFormat.parse(arr[2]);
              a1.duration = Double.parseDouble(arr[3]);
              a1.distance = Double.parseDouble(arr[4]);
              a1.avg_heart_rate = Double.parseDouble(arr[5]);
              a1.intensity = Double.parseDouble(arr[6]);
              activities.add(a1);
          }
      }
      else{
          activities.clear();
          Scanner s = new Scanner(new File(filepath));
          SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
          while (s.hasNext()) {
              String sp = s.next();
              String[] arr = sp.split(",");
              Activity a1 = new Activity(arr[0], arr[1], dateFormat.parse(arr[2]), Double.parseDouble(arr[3]), Double.parseDouble(arr[4]), Double.parseDouble(arr[5]), Double.parseDouble(arr[6]));
              a1.Person_name = arr[0];
              a1.Activity_name = arr[1];
              a1.date = dateFormat.parse(arr[2]);
              a1.duration = Double.parseDouble(arr[3]);
              a1.distance = Double.parseDouble(arr[4]);
              a1.avg_heart_rate = Double.parseDouble(arr[5]);
              a1.intensity = Double.parseDouble(arr[6]);
              activities.add(a1);
          }

      }
    }

    /**
     * BinarySearch for finding activity
     *
     */
    public static void ActivityBinarysearch(ArrayList<Activity> activities){
        Scanner sc=new Scanner(System.in);
        Collections.sort(activities);
        Activity a1=new Activity();

        System.out.println("Enter the Activity_name: ");
        a1.setActivity_name(sc.next());
        System.out.println("Enter the Person_name: ");
        a1.setPerson_name(sc.next());
        //For date
        System.out.println("Enter the Date(dd/MM/yyyy): ");
        String dateString = sc.next();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = dateFormat.parse(dateString);
            a1.setDate(date);
        } catch (ParseException e) {
            System.out.println("Invalid date format, Please use dd/MM/yyyy format.");
            // Handle the error or exit the program as needed
        }
        System.out.println("Enter the Duration(in mins): ");
        a1.setDuration(sc.nextDouble());
        System.out.println("Enter the Distance(in km): ");
        a1.setDistance(sc.nextDouble());
        System.out.println("Enter the avg heart rate: ");
        a1.setavg_heart_rate(sc.nextDouble());
        System.out.println("Enter the Intensity: ");
        a1.setIntensity(sc.nextDouble());

       Activity a2=new Activity(a1.Activity_name,a1.Person_name,a1.date,a1.duration,a1.distance,a1.avg_heart_rate,a1.intensity);

       int i= Collections.binarySearch(activities,a2,Comparator.comparing(Activity::getDistance));
        if(i>0){
            System.out.println("Found the following activity: "+activities.get(i));
        }
        else{
            System.out.println("Can not find the following activity");
        }

    }

    /**
     * display activites
     */
    public static void displayactivities(){
        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s \n",
                "Person Name", "Activity Type", "Date", "Duration", "Distance", "Avg Heart Rate", "CaloriesBurned", "Intensity","Enum");
        System.out.println(new String(new char[146]).replace("\0", "-"));

        for (Activity activity : activities) {
            Activity.level.getDATA_enum(activity);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String date = simpleDateFormat.format(activity.getDate());
            System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15.2f | %-15s |%-15s \n",
                    activity.getPerson_name(), activity.getActivity_name(),
                    date, activity.getDuration(), activity.getDistance(),
                    activity.getAvg_heart_rate(),(activity.getDuration()*activity.getIntensity()), activity.getIntensity(),activity.getLevel());
        }
    }

    /**
     * Display sorted activities
     *
     */
    public static  void displaySortedActivities(ArrayList<Activity> activities) {
        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s \n",
                "Person Name", "Activity Type", "Date", "Duration", "Distance", "Avg Heart Rate", "CaloriesBurned", "Intensity","Enum");
        System.out.println(new String(new char[146]).replace("\0", "-"));

        for (Activity activity : activities) {
            Activity.level.getDATA_enum(activity);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String date = simpleDateFormat.format(activity.getDate());
            System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15.2f | %-15s |%-15s \n",
                    activity.getPerson_name(), activity.getActivity_name(),
                    date, activity.getDuration(), activity.getDistance(),
                    activity.getAvg_heart_rate(),(activity.getDuration()*activity.getIntensity()), activity.getIntensity(),activity.getLevel());
        }
    }

    /**
     * view statistics
     *
     */
    public static   void viewStatistics(ArrayList<Activity>activities) {
        int totalDuration = 0;
        double totalDistance = 0;
        int totalHeartRate = 0;
        int activityCount = activities.size();

        for (Activity activity : activities) {
            totalDuration += (int) activity.getDuration();
            totalDistance += activity.getDistance();
            totalHeartRate += (int) activity.getAvg_heart_rate();
        }

        double averageDuration = (double) totalDuration / activityCount;
        double averageDistance = totalDistance / activityCount;
        double averageHeartRate = (double) totalHeartRate / activityCount;

        System.out.println("Statistics:");
        System.out.println("Total Activities: " + activityCount);
        System.out.println("Total Duration: " + totalDuration + " minutes");
        System.out.println("Total Distance: " + totalDistance + " km");
        System.out.println("Average Duration: " + averageDuration + " minutes");
        System.out.println("Average Distance: " + averageDistance + " km");
        System.out.println("Average Heart Rate: " + averageHeartRate);
    }

    /**
     * TO get statisics by name
     * personName
     *
     */
    public static void viewStatisticsByName(String personName) {
        int totalDuration = 0;
        double totalDistance = 0;
        int totalHeartRate = 0;
        double totalCaloriesBurned = 0;
        int activityCount = 0;

        for (Activity activity : activities) {
            if (activity.getPerson_name().equals(personName)) {
                totalDuration += (int) activity.getDuration();
                totalDistance += activity.getDistance();
                totalHeartRate += (int) activity.getAvg_heart_rate();
                totalCaloriesBurned += (activity.getIntensity()*activity.getDuration());
                activityCount++;
            }
        }

        if (activityCount > 0) {
            double averageDuration = (double) totalDuration / activityCount;
            double averageDistance = totalDistance / activityCount;
            double averageHeartRate = (double) totalHeartRate / activityCount;
            double averageCaloriesBurned = totalCaloriesBurned / activityCount;

            System.out.println("Statistics for " + personName + ":");
            System.out.println("Total Activities: " + activityCount);
            System.out.println("Total Duration: " + totalDuration + " minutes");
            System.out.println("Total Distance: " + totalDistance + " km");
            System.out.println("Average Duration: " + averageDuration + " minutes");
            System.out.println("Average Distance: " + averageDistance + " km");
            System.out.println("Average Heart Rate: " + averageHeartRate);
            System.out.println("Average Calories Burned: " + averageCaloriesBurned);
        }
        else {
            System.out.println("No activities found for " + personName);
        }
    }
}


































