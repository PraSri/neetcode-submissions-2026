/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a.start));
        if(intervals.size() == 0){
        return true;
    }
    int prevEndTime = intervals.get(0).end;
    for(int i = 1; i<intervals.size(); i++) {
        int currStartTime = intervals.get(i).start;
        if(currStartTime < prevEndTime) {
            return false;
        }
        prevEndTime = intervals.get(i).end;
    }
    return true;
    }
}
