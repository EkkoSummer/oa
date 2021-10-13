package twitter.ge;

import java.util.*;

public class GameEvents {

    public static void main(String[] args) {
        List<String> event1 = new ArrayList<>();
        List<String> event2 = new ArrayList<>();
        String team1 = "EDC";
        String team2 = "CDE";
        event1.add("Name1 12 G");
        event1.add("FirstName LastName 43 Y");
        event2.add("Name3 45+1 S SubName");
        event2.add("Name4 46 G");
        GameEvents ge = new GameEvents();
        System.out.println(ge.getEventsOrder(team1, team2, event1, event2));
    }

    class Score{
        int actualTime;
        String timeString;
        String teamName;
        String playerName;
        String substituteName;
        char eventType;
        boolean isFirstHalf;
        String originalString;

        public Score(int actualTime, String timeString, String teamName, String playerName, String substituteName, char eventType, boolean isFirstHalf, String originalString){
            this.actualTime = actualTime;
            this.timeString = timeString;
            this.teamName = teamName;
            this.playerName = playerName;
            this.substituteName = substituteName;
            this.eventType = eventType;
            this.isFirstHalf = isFirstHalf;
            this.originalString = originalString;
        }
    }

    Map<Character, Integer> map = new HashMap<>();

    public List<String> getEventsOrder(String team1, String team2, List<String> events1, List<String> events2){
        map.put('G',1);
        map.put('Y',2);
        map.put('R',3);
        map.put('S',4);
        List<Score> scoreList = new ArrayList<>();
        for(String e1 : events1){
            scoreList.add(parseString(e1, team1));
        }
        for(String e2 : events2){
            scoreList.add(parseString(e2, team2));
        }
        Collections.sort(scoreList, (s1,s2) -> {
           if(s1.isFirstHalf && !s2.isFirstHalf){
               return -1;
           }
           if(!s1.isFirstHalf && s2.isFirstHalf){
               return 1;
           }
           if(s1.actualTime != s2.actualTime){
               return s1.actualTime - s2.actualTime;
           }
           if(map.get(s1.eventType) != map.get(s2.eventType)){
               return map.get(s1.eventType) - map.get(s2.eventType);
            }
           if(!s1.teamName.equals(s2.teamName)){
               return s1.teamName.compareTo(s2.teamName);
           }
           return s1.playerName.compareTo(s2.playerName);
        });
        List<String> ret = new ArrayList<>();
        for(Score score : scoreList){
            ret.add(score.teamName + " " + score.originalString);
        }
        return ret;
    }

    public Score parseString(String str, String teamName){
        String[] words = str.split(" ");
        int timeIndex = getTimeIndex(words);
        char event = words[timeIndex+1].charAt(0);
        String playerName = "";
        for(int i=0; i<timeIndex; i++){
            playerName = playerName + " " + words[i];
        }
        playerName.trim();
        String sub = "";
        if(event=='S'){
            for(int i=timeIndex+2; i< words.length; i++){
                sub += words[i] + " ";
            }
            sub = sub.trim();
        }
        int actualTime = 0;
        boolean isFirstHalf = false;
        if(words[timeIndex].contains("+")){
            String timeSplit[] = words[timeIndex].split("\\+");
            actualTime += Integer.parseInt(timeSplit[0]);
            if(actualTime<=45){
                isFirstHalf = true;
            }
            actualTime += Integer.parseInt(timeSplit[1]);
        }else{
            actualTime += Integer.parseInt(words[timeIndex]);
            if(actualTime<=45){
                isFirstHalf = true;
            }
        }
        Score score = new Score(actualTime, words[timeIndex], teamName, playerName, sub, event, isFirstHalf, str);
        return score;
    }

    public int getTimeIndex(String[] words){
        for(int i=0; i<words.length; i++){
            if(Character.isDigit(words[i].charAt(0))){
                return i;
            }
        }
        return -1;
    }

}
