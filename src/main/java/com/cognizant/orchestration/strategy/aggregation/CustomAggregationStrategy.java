package com.cognizant.orchestration.strategy.aggregation;

import java.util.List;

import org.mule.DefaultMuleEvent;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.routing.AggregationContext;
import org.mule.routing.AggregationStrategy;

import com.cognizant.orchestration.dto.PointOfInterest;
import com.cognizant.orchestration.dto.PushNotificationSuccessRS;
import com.cognizant.orchestration.dto.Reservation;

public class CustomAggregationStrategy implements AggregationStrategy {

	@SuppressWarnings("unchecked")
	@Override
	public MuleEvent aggregate(AggregationContext context) throws MuleException {
		final PushNotificationSuccessRS pushNotificationResponse = new PushNotificationSuccessRS();
		final List<MuleEvent> muleEvents = context.collectEventsWithoutExceptions();
		MuleEvent result = null;
		for (final MuleEvent muleEvent : muleEvents) {
			final Object payload = muleEvent.getMessage().getPayload();
			if (payload instanceof List) {
				
				final List<Object> payloads = (List<Object>)payload;
				for(Object payld : payloads){
					if(payld instanceof Reservation){
						pushNotificationResponse.setReservations((List<Reservation>) payload);
						if (result == null) {
							result = DefaultMuleEvent.copy(muleEvent);
						}
						break;
					}
					else if(payld instanceof PointOfInterest){
						pushNotificationResponse.setPoi((List<PointOfInterest>) payload);
						if (result == null) {
							result = DefaultMuleEvent.copy(muleEvent);
						}
						break;
					}
				}
				
			}
		}
		if(result!=null){
			result.getMessage().setPayload(pushNotificationResponse);
		}
		return result;
	}

}
