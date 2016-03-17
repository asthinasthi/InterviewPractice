import java.util.Arrays;
import java.util.Comparator;

import javax.xml.crypto.dsig.CanonicalizationMethod;

public class MeetingRooms {
	Interval interval1 = new Interval(0, 30);
	Interval interval2 = new Interval(31, 40);
	Interval interval3 = new Interval(41, 50);
	Interval[] intervals = { interval1, interval2, interval3};
	
	public  void main(String[] args) {
		new MeetingRooms().canAttendAllMeetings(intervals);
	}

	public  boolean canAttendAllMeetings(Interval[] intervals){
		if(intervals.length == 0 || intervals == null){
			return true;
		}
		
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		
		for(int i=0; i < intervals.length-1;i++){
			if(intervals[i].end > intervals[i+1].start){
				return false;
			}
		}
		return true;
	}
	
	public class Interval{
		int start;
		int end;
		public Interval(int s, int e){
			this.start = s;
			this.end = e;
		}
	}

}

