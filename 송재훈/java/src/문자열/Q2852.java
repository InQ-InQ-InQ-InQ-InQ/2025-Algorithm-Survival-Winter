package 문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q2852 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int goalCount = Integer.parseInt(br.readLine());

        int curTime = 0;
        int endTime = 48 * 60;
        List<Integer> team1LeadStartTime = new ArrayList<>();
        List<Integer> team2LeadStartTime = new ArrayList<>();
        int team1Score = 0;
        int team2Score = 0;
        String leadTeam = "";

        for(int i = 0; i < goalCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String team = st.nextToken();
            String time = st.nextToken();
            String[] timeSplit = time.split(":");
            curTime = Integer.parseInt(timeSplit[0]) * 60 + Integer.parseInt(timeSplit[1]);
            if (team.equals("1")) {
                team1Score++;
            } else {
                team2Score++;
            }

            if (leadTeam.isEmpty()) { // 처음 리드가 발생한 경우
                if (team1Score > team2Score) {
                    leadTeam = "1";
                    team1LeadStartTime.add(curTime); // 팀 1 리드 시작
                } else if (team2Score > team1Score) {
                    leadTeam = "2";
                    team2LeadStartTime.add(curTime); // 팀 2 리드 시작
                }
            } else if (team1Score > team2Score && leadTeam.equals("2")) { // 팀 1이 새로 리드
                leadTeam = "1";
                team2LeadStartTime.add(curTime); // 팀 2 리드 종료
                team1LeadStartTime.add(curTime); // 팀 1 리드 시작
            } else if (team2Score > team1Score && leadTeam.equals("1")) { // 팀 2가 새로 리드
                leadTeam = "2";
                team1LeadStartTime.add(curTime); // 팀 1 리드 종료
                team2LeadStartTime.add(curTime); // 팀 2 리드 시작
            } else if (team1Score == team2Score) { // 동점인 경우
                if (leadTeam.equals("1")) {
                    team1LeadStartTime.add(curTime); // 팀 1 리드 종료
                } else if (leadTeam.equals("2")) {
                    team2LeadStartTime.add(curTime); // 팀 2 리드 종료
                }
                leadTeam = ""; // 현재 리드 없음
            }
        }

        if(leadTeam.equals("1")) {
            team1LeadStartTime.add(endTime);
        }else{
            team2LeadStartTime.add(endTime);
        }

        int team1Result = 0;
        int team2Result = 0;

        for(int i = 0; i < team1LeadStartTime.size() - 1; i += 2) {
            team1Result += team1LeadStartTime.get(i + 1) - team1LeadStartTime.get(i);
        }

        for(int i = 0; i < team2LeadStartTime.size() - 1; i += 2) {
            team2Result += team2LeadStartTime.get(i + 1) - team2LeadStartTime.get(i);
        }

        bw.write(String.format("%02d:%02d\n", team1Result / 60, team1Result % 60));
        bw.write(String.format("%02d:%02d\n", team2Result / 60, team2Result % 60));
        bw.flush();
    }
}
