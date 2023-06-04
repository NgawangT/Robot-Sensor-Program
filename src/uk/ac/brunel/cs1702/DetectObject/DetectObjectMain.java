package uk.ac.brunel.cs1702.DetectObject;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class DetectObjectMain {
	//static makes it part of the class so it can be used throughout the class
	static int mode = 0;
	static Finch myfinch;// = new Finch();
	static long startTime;
	static long endTime;
	static int counter = 0;  
	static String moderan; //amode
	static long duration = 0;

	public static void detectobject(Finch finch) {//detect object function , method for calling finch
		myfinch = finch; //finch has been declared

	}

	public static void curious() { //curious method
		counter = 0; //counter set to 0 
		moderan="Curious"; //previously amode now moderan assigned moderan into curious within the curious method. So that if the any method generates curious displays curious
		startTime= System.currentTimeMillis(); //starts the system clock current time in milliseconds. 
		while((myfinch.isFinchLevel()== true) &&(myfinch.isBeakUp()==false)){ //while the finch is level and beak is not up runs the code within its bracket
			long quicktimer = System.currentTimeMillis(); //declared quick timer as long and assigned it to the systems current time in millis.  
			do {// do this connects with the while loop below
				myfinch.setLED(255, 255, 255); //Led colour white
				myfinch.setWheelVelocities(80, 80); //move forward at speed of 80(left wheel), 80(right wheel).
				if ((myfinch.isObstacle() == false) && (System.currentTimeMillis() - quicktimer > 4999)) { //if obstacle not found within 5 seconds 
					myfinch.setWheelVelocities(0, 0, 1000); //stops the wheels for a second
					myfinch.setWheelVelocities(-75, 100, 1000); //changes direction towards left 
					quicktimer = System.currentTimeMillis(); //ends the QuickTimer for the direction change
				}

			} // do

			while (myfinch.isObstacle() == false && (myfinch.isFinchLevel() == true)); //do the steps while no obstacle and the finch is level.
				
			counter++;  //increment of counter each time obstacle encountered.
			while (myfinch.isObstacle() == true) { //while loop when obstactle is true
				if ((myfinch.isObstacleRightSide() == true) && (myfinch.isObstacleLeftSide() == false)) {//if right sensor true
					myfinch.setLED(0,255,0); //led green 
					myfinch.setWheelVelocities(100, 55); //move towards right 
				} else if ((myfinch.isObstacleLeftSide() == true) && (myfinch.isObstacleRightSide() == false)) { //if left sensor true
					myfinch.setLED(0,255,0); //led green
					myfinch.setWheelVelocities(55, 100); //move towards left
				} else { //i had the counter here , i wanted it to count the object only if it detects both sensors. So the detected number is not skyhigh
					myfinch.setWheelVelocities(0, 0); //stop the wheels because finch sleep wasn't working 
					myfinch.setLED(0,0,255); //Led blue 
				}
		

			} //due to this while loop then led goes from green to blue then blue to green when object stops then moves.
		} //breaks from the loop when finch is picked up
		System.out.println("Finch not level on floor so program ended"); //program terminates when finch not level.
		myfinch.setLED(0,0,0); //stop the led 
		myfinch.setWheelVelocities(0, 0); //stop the wheels
		DetectGUI.Endpage(); //calls the end page method 
		endTime = System.currentTimeMillis(); //end time for the mode recorded 
	}


	public static void Scaredy() {
		counter = 0; //counter set to 0 
		moderan="Scaredy"; //for log to display that scaredy mode was ran. assigned moderan as the string scaredy (initialised)
		startTime= System.currentTimeMillis(); //Start the timer 
		while((myfinch.isFinchLevel()== true) &&(myfinch.isBeakUp()==false)){ //while the finch is level and beak is up
			long quicktimer = System.currentTimeMillis(); //declared and initialised quicktimer.
			
			while (myfinch.isObstacle() == false && (myfinch.isFinchLevel() == true)) {//while loop for when no obstacle and finch is level 
				myfinch.setLED(0, 255, 0); //green led 
				myfinch.setWheelVelocities(75, 75); //move forward
				if ((myfinch.isObstacle() == false) && (System.currentTimeMillis() - quicktimer > 4999)) { //if no obstacle found within 5 seconds do this
					myfinch.setWheelVelocities(-75, 100, 1000);//changes direction towards left
					quicktimer = System.currentTimeMillis(); //ends the QuickTimer for the direction change
				}
			} 

			if (myfinch.isObstacle() == true) { // if obstacle is found within 5 seconds do this
				counter++; //increment counter 
				myfinch.setWheelVelocities(0, 0, 1000); //pause of 1 second
				myfinch.setLED(255,0, 0); //green led why does this work for led red if this taken out led stays green

				myfinch.buzz(25000, 2000); //buzz
				myfinch.setWheelVelocities(-100, -100, 1000);//reverse for a second

				myfinch.setWheelVelocities(140, -140, 1100);//change direction 180
				myfinch.setWheelVelocities(250, 250, 3000); //move forward for 3 seconds
				myfinch.setLED(0, 255, 0); //need this for led red 
			}

		} //breaks from the loop when finch is picked up
		System.out.println("Finch not level on floor so program ended"); 
		myfinch.setLED(0, 0, 0); //turns led off
		myfinch.setWheelVelocities(0, 0); //stop the wheels
        DetectGUI.Endpage(); //calls the end page 
        endTime = System.currentTimeMillis(); //end time for the mode recorded
		
	}

	public static void Any() { //method for Any mode , this mode generates a random number between 1 or 2 and selects the mode assigned to that integer. 1 = curious and 2 = scaredy
		int x = (int) (Math.random() * ((2 - 1) + 1)) + 1; //declared int x and assigned it to math.random function which retruns a double value with a positive sign equal to 0, 0 and less than 1.0

		if (x == 1) { // if generated number is 1 then selects curious mode and runs that mode. 
			System.out.println("Finch is Curious"); //print
			curious(); //calls the method for curious mode
		} else if (x == 2) {
			System.out.println("Finch is Scared"); //print
			Scaredy(); // calls the method for scaredy mode
		}

	}

	public static void log() { //this method displays the log of the executed modes.
		System.out.println("\nlog:"); //print log after a line 
		System.out.println("Mode ran:"+ moderan); //shows which mode was ran (previously amode) string + variable 
		duration = 0; //duration is assigned a value 0 
		duration = ((endTime-startTime)/1000); //duration is assigned to this calculation 
		System.out.println("The duration of execution was:" + ((duration) + " seconds")); // duration of the modes 
		System.out.println("No of times object encountered:" + counter);// no of times finch encountered object

	}

}



		


	





