import java.util.Scanner;

class Berkeley{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("Enter total no. of processes (including master)");
		int noOfProcesses = sc.nextInt();

		double masterTime = 45000;
		System.out.println("Assumming server time to be 12:30 pm");
		System.out.println("Number of seconds lapsed since midnight is " + masterTime);

		double slaveTime[] = new double[noOfProcesses-1];
		/*
		System.out.println("Enter time of each slave in terms of number of seconds lapsed since midnight");
		for (int i=0; i<noOfProcesses-1; i++) {
			System.out.println("For slave " + i);
			slaveTime[i] = sc.nextDouble();
		}*/

		System.out.println("Enter time of each slave in hh:mm:ss format");
		for (int i=0; i<noOfProcesses-1; i++) {
			System.out.println("For slave " + i);
			String timeString = sc.next();
			slaveTime[i] = convertStringToseconds(timeString);
			System.out.println("Time of slave " + i + " in terms of number of seconds lapsed since midnight " + slaveTime[i]);
		}

		double timeDifference[] = new double[noOfProcesses-1];

		slaveResponse(masterTime, slaveTime, timeDifference, noOfProcesses);

		double sum = 0, average = 0;

		System.out.println("timeDifference is");
		for (int i=0; i<noOfProcesses-1; i++) {
			System.out.println("For slave " + i);
			System.out.println(timeDifference[i]);
			sum += timeDifference[i];
		}

		average = sum/noOfProcesses;
		System.out.println("Average = " + average);

		double offsetTime[] = new double[noOfProcesses-1];
		computeOffsetTime(average, timeDifference, offsetTime, noOfProcesses);

		masterTime += average;
		adjustTime(slaveTime, offsetTime, noOfProcesses);
		System.out.println("After Synchronization:");
		System.out.println("Time at master is " + masterTime);
		System.out.println("Time at slaves is ");
		for (int i=0; i<noOfProcesses-1; i++) {
			System.out.println("For slave " + i);
			System.out.println(slaveTime[i]);
		}
	}

	static void slaveResponse(double masterTime, double slaveTime[], double timeDifference[], int noOfProcesses){
		for (int i=0; i<noOfProcesses-1; i++) {
			timeDifference[i] = slaveTime[i] - masterTime;
		}
	}

	static void adjustTime(double slaveTime[], double offsetTime[], int noOfProcesses){
		
		for (int i=0; i<noOfProcesses-1; i++) {
			slaveTime[i] += offsetTime[i];
		}
	}

	static void computeOffsetTime(double average, double timeDifference[], double offsetTime[], int noOfProcesses){
		for (int i=0; i<noOfProcesses-1; i++) {
			offsetTime[i] = average - timeDifference[i];
		}
	}

	static double convertStringToseconds(String timeString){
		String timeStringArray[] = timeString.split(":");
		double time[] = new double[3];

		System.out.println("hh:mm:ss");
		for (int i=0; i<3; i++) {
			time[i] = Double.valueOf(timeStringArray[i]);
			System.out.print(time[i] + " : ");
		}
		System.out.println();
		return time[0]*3600 + time[1]*60 + time[2];
	}

}