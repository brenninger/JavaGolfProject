import java.text.DecimalFormat;


public class calcHandicap {
	double score;
	int numOfScores;
	int strokes;
	double differential;
	double courseRating;
	int slope;
	double sumOfDiff;
	DecimalFormat df = new DecimalFormat("#.##");
	
	public calcHandicap()
	{
		score = 0;
		strokes = 0;
		numOfScores = 0;
		calculations();
	}
	public calcHandicap(int s)
	{
		strokes = s;
		calculations();
	}
	public calcHandicap(int s, int n)
	{
		strokes = n;
		numOfScores = s;
		calculations();
	}
	public calcHandicap(int s, double c, int sl)
	{
		strokes = s;
		courseRating = c;
		slope = sl;
		calculations();
	}

	public double calculations()
	{
		differential = ((strokes - courseRating) * 113) / slope;
		return differential;
	}
	public String toString()
	{
		return "Your differential is " + df.format(differential);
	}
	
}
