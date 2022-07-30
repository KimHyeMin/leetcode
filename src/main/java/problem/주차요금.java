package problem;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class 주차요금 {

    public int[] solution(int[] fees, String[] records) {

        int baseTime = fees[0];         //기본시간
        int baseCharge = fees[1];       //기본요금
        int perTime = fees[2];          //단위시간
        int perCharge = fees[3];        //단위 요금

        ParkingFeeCalculator calculator = new ParkingFeeCalculator(baseTime, baseCharge, perTime, perCharge);

        HashMap<String, ParkingHistory> history = new HashMap<>();

        for (String record : records) {
            String[] split = record.split(" ");
            String time = split[0];
            String carNumber = split[1];
            String behavior = split[2];

            ParkingHistory parkingHistory = history.get(carNumber);

            if (parkingHistory == null) {
                history.put(carNumber, new ParkingHistory(carNumber, time));
            } else {
                if ("IN".equals(behavior)) {
                    parkingHistory.accumulateTime();
                    parkingHistory.setInTime(time);
                } else {
                    parkingHistory.setOutTime(time);
                }
            }
        }

        List<String> targetCarList = history.keySet().stream().sorted().collect(Collectors.toList());

        int[] answer = new int[targetCarList.size()];
        int i = 0;
        for (String carNum : targetCarList) {
            ParkingHistory parkingHistory = history.get(carNum);
            answer[i++] = calculator.calculate(parkingHistory.getTotalTime());
        }
        return answer;
    }

}

class ParkingFeeCalculator {

    int baseTime, baseCharge, perTime, perCharge;

    public ParkingFeeCalculator(int baseTime, int baseCharge, int perTime, int perCharge) {
        this.baseTime = baseTime;
        this.baseCharge = baseCharge;
        this.perTime = perTime;
        this.perCharge = perCharge;
    }

    public int calculate(int totalTime) {
        if (totalTime <= baseTime) {
            return baseCharge;
        }
        int overTime = totalTime - baseTime;
        int te = overTime/perTime + (overTime%perTime > 0 ? 1 : 0);
        return baseCharge + te*perCharge;
    }
}

class ParkingHistory {
    String carNumber;
    int accumulatedTime;
    Time inTime;
    Time outTime;

    public ParkingHistory(String carNumber, String inTime) {
        this.carNumber = carNumber;
        this.inTime = new Time(inTime);
    }

    public int getTotalTime() {
        if (inTime!= null && outTime == null) {
            return this.accumulatedTime + between(this.inTime, new Time("23:59"));
        }
        return this.accumulatedTime + between(this.inTime, this.outTime);
    }

    public void accumulateTime() {
        this.accumulatedTime = this.accumulatedTime + between(inTime, outTime);
        //init
        this.inTime = null;
        this.outTime = null;
    }

    int between(Time inTime, Time outTime) {
        LocalTime total = outTime.time.minusHours(inTime.time.getHour()).minusMinutes(inTime.time.getMinute());
        return total.getHour()*60 + total.getMinute();
    }

    public void setOutTime(String time) {
        this.outTime = new Time(time);
    }

    public void setInTime(String time) {
        this.inTime = new Time(time);
    }
}

class Time {

    LocalTime time;

    public Time(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);
        this.time = LocalTime.of(hour, minute);
    }
}
