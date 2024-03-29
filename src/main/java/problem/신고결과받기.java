package problem;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
//        Map<String, Integer> marking = new HashMap<>();
//        Map<String, List<String>> reportMap = new HashMap<>();
//
//        //init
//        for (String name : id_list) {
//            marking.put(name, 0);
//            reportMap.put(name, new ArrayList<>());
//        }
//
//        for (String line : report) {
//            String[] split = line.split(" ");
//            String from = split[0];
//            String to = split[1];
//
//            Integer cnt = marking.get(to);
//            marking.put(to, cnt+1);
//
//            List<String> list = reportMap.get(from);
//            list.add(to);
//            reportMap.put(from, list);
//        }
//
//        int[] answer = new int[id_list.length];
//
//        for (int i = 0; i < id_list.length ; i++) {
//            List<String> reportTarget = reportMap.get(id_list[i]);
//            long count = reportTarget.stream().filter(name -> marking.get(name) >= k).count();
//            answer[i] = (int) count;
//        }
//        return answer;

//        Map<String, Integer> index = new HashMap<>();
//        int[] count = new int[id_list.length];
//        boolean[][] reportArr= new boolean[id_list.length][id_list.length];
//
//        for (int i = 0 ; i<id_list.length;i++) {
//            index.put(id_list[i], i);
//        }
//
//        for (String line : report) {
//            String[] split = line.split(" ");
//            String from = split[0];
//            String to = split[1];
//
//            int fromIdx = index.get(from);
//            int toIdx = index.get(to);
//
//            if (reportArr[fromIdx][toIdx]) {
//                continue;
//            }
//            reportArr[fromIdx][toIdx] = true;
//            count[toIdx] = count[toIdx] + 1;
//        }
//
//        int[] answer = new int[id_list.length];
//
//        for (int i = 0; i < id_list.length ; i++) {
//            int cnt = 0;
//            for (int j =0 ;j<id_list.length;j++) {
//                if (i == j) continue;
//                if (reportArr[i][j] && count[j]>=k) {
//                    cnt ++;
//                }
//            }
//            answer[i] = cnt;
//        }
//        return answer;

        int[] answer = new int[id_list.length];
        Map<String, Integer> reporterIndex = IntStream
                .range(0, id_list.length)
                .boxed()
                .collect(Collectors.toMap(
                    index -> id_list[index],
                    index -> index
                ));

        Map<String, Set<String>> reportRecords = new HashMap<>();

        for (String line : report) {
            String[] split = line.split(" ");
            String newReporter = split[0];
            String reportTarget = split[1];

            if (reportRecords.containsKey(reportTarget) == false) {
                reportRecords.put(reportTarget, new HashSet<>());
            }

            Set<String> reporterSet = reportRecords.get(reportTarget);
            if (reporterSet.contains(newReporter)) {
                continue;
            }
            reporterSet.add(newReporter);

            if (reporterSet.size() == k) {
                reporterSet.forEach(reporter -> ++answer[reporterIndex.get(reporter)]);
            } else if (reporterSet.size() > k) {
                ++answer[reporterIndex.get(newReporter)];
            }
        }

        return answer;
    }

}
