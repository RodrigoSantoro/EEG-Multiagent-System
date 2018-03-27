!listen.

+!listen
	:	activity[source(parietal_agent1)] & activity[source(parietal_agent2)]
	<-	.print("activity happening in the PARIETAL LOBE");
		parietal_signal_detected;
		-activity[source(parietal_agent1)];
		-activity[source(parietal_agent2)];
		!!listen.
		
+!listen
	:	activity[source(frontal_agent1)] & activity[source(frontal_agent2)]
	<-	.print("activity happening in the FRONTAL LOBE");
		frontal_signal_detected;
		-activity[source(frontal_agent1)];
		-activity[source(frontal_agent2)];
		!!listen.
		
+!listen
	:	activity[source(occipital_agent1)] & activity[source(occipital_agent2)]
	<-	.print("activity happening in the OCCIPITAL LOVE");
		occipital_signal_detected;
		-activity[source(occipital_agent1)];
		-activity[source(occipital_agent2)];
		!!listen.
		
+!listen
	:	activity[source(temporal_agent1)] & activity[source(temporal_agent2)]
	<-	.print("activity happening in the TEMPORAL LOBE");
		temporal_signal_detected;
		-activity[source(temporal_agent1)];
		-activity[source(temporal_agent2)];
		!!listen.

+!listen
	:	no_activity[source(parietal_agent1)] & no_activity[source(parietal_agent2)]
	<-	nothing_detected;
		-no_activity[source(parietal_agent1)];
		-no_activity[source(parietal_agent2)];
		!!listen.

+!listen
	:	no_activity[source(frontal_agent1)] & no_activity[source(frontal_agent2)]
	<-	nothing_detected;
		-no_activity[source(frontal_agent1)];
		-no_activity[source(frontal_agent2)];
		!!listen.

+!listen
	:	no_activity[source(occipital_agent1)] & no_activity[source(occipital_agent2)]
	<-	nothing_detected;
		-no_activity[source(occipital_agent1)];
		-no_activity[source(occipital_agent2)];
		!!listen.
		
+!listen
	:	no_activity[source(temporal_agent1)] & no_activity[source(temporal_agent2)]
	<-	nothing_detected;
		-no_activity[source(temporal_agent1)];
		-no_activity[source(temporal_agent2)];
		!!listen.

+!listen
	: true
	<- nothing_detected;
		!!listen.
		
-!listen
	:	true
	<-	nothing_detected;
		!listen.