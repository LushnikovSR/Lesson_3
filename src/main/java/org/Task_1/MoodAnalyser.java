package org.Task_1;

public class MoodAnalyser {

    public static String analyseMood(String message) {
        if (message == "That is a great day") return "Good";
        else if (message == "It`s a bad day today") return "Terrible";
        return "Normal";
    }

}
