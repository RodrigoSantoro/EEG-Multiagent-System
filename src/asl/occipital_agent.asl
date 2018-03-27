!detect.

+!detect
	:	true
	<-	detect;
		?activity;
		.print("activity detected");
		.send(overseeing_agent, tell, activity);
		!detect.

-!detect
	:	true
	<-	.print("detecting");
		.send(overseeing_agent, tell, no_activity);
		!detect.